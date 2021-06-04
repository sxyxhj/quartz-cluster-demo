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

    public boolean addJob(String jobName, String jobGroup, String cronExpression) {

        try{
            scheduler.start();

            JobDetail detail = JobBuilder.newJob(MyJob.class).withIdentity(jobName,jobGroup).build();
            CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(cronExpression);

            CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity(jobName,jobGroup).withSchedule(cronScheduleBuilder).build();
            scheduler.scheduleJob(detail,trigger);
            return true;
        }catch (Exception e){
            log.error("定时任务创建失败------");
            log.error("addJob throw an exception:",e);
            return false;
        }
    }

    public boolean pauseJob(String jobName, String jobGroup) {
        try {
            scheduler.pauseJob(JobKey.jobKey(jobName,jobGroup));
            return true;
        } catch (SchedulerException e) {
            log.error("pauseJob throw an exception:",e);
            return false;
        }
    }

    public boolean resumeJob(String jobName, String jobGroup) {
        try {
            scheduler.resumeJob(JobKey.jobKey(jobName,jobGroup));
            return true;
        } catch (SchedulerException e) {
            log.error("resumeJob throw an exception:",e);
            return false;
        }
    }

    public boolean rescheduleJob(String jobName, String jobGroup, String cronExpression){

        try {
            TriggerKey triggerKey = TriggerKey.triggerKey(jobName,jobGroup);
            CronScheduleBuilder builder = CronScheduleBuilder.cronSchedule(cronExpression);
            CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
            trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(builder).build();

            scheduler.rescheduleJob(triggerKey,trigger);
            return true;
        } catch (SchedulerException e) {
            log.error("rescheduleJob throw an exception:",e);
            return false;
        }



    }

    public boolean deleteJob(String jobName, String jobGroup){
        try {
            return scheduler.deleteJob(JobKey.jobKey(jobName,jobGroup));
        } catch (SchedulerException e) {
            log.error("deleteJob throw an exception:",e);
            return false;
        }
    }

    public boolean triggerJob(String jobName, String jobGroup){
        try {
            scheduler.triggerJob(JobKey.jobKey(jobName,jobGroup));
            return true;
        } catch (SchedulerException e) {
            log.error("triggerJob throw an exception:",e);
            return false;
        }
    }
}
