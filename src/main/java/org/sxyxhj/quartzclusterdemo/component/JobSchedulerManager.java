package org.sxyxhj.quartzclusterdemo.component;

import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.sxyxhj.quartzclusterdemo.job.MyJob;

/**
 * @program: quartz-cluster-demo
 * @description:
 * @author: elroyh
 * @create: 2021-06-02 16:05
 **/

@Component
@Slf4j
public class JobSchedulerManager {


    @Autowired
    @Qualifier("Scheduler")
    Scheduler scheduler;

    public void addJob(String jobName, String jobGroup, String cronExpression) throws Exception {

        scheduler.start();

        JobDetail detail = JobBuilder.newJob(MyJob.class).withIdentity(jobName,jobGroup).build();
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(cronExpression);

        CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity(jobName,jobGroup).withSchedule(cronScheduleBuilder).build();

        try{
            scheduler.scheduleJob(detail,trigger);
        }catch (Exception e){
            log.error("定时任务创建失败------");
        }



    }

    public void pauseJob(String jobName, String jobGroup) throws Exception {
        scheduler.pauseJob(JobKey.jobKey(jobName,jobGroup));
    }

    public void resumeJob(String jobName, String jobGroup) throws Exception{
        scheduler.resumeJob(JobKey.jobKey(jobName,jobGroup));
    }

    public void rescheduleJob(String jobName, String jobGroup, String cronExpression) throws Exception {

        TriggerKey triggerKey = TriggerKey.triggerKey(jobName,jobGroup);
        CronScheduleBuilder builder = CronScheduleBuilder.cronSchedule(cronExpression);
        CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);

        trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(builder).build();

        scheduler.rescheduleJob(triggerKey,trigger);


    }

    public void deleteJob(String jobName, String jobGroup) throws Exception  {
        scheduler.deleteJob(JobKey.jobKey(jobName,jobGroup));
    }

    public void triggerJob(String jobName, String jobGroup) throws Exception  {
        scheduler.triggerJob(JobKey.jobKey(jobName,jobGroup));
    }
}
