package org.sxyxhj.quartzclusterdemo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.sxyxhj.quartzclusterdemo.component.JobSchedulerManager;
import org.sxyxhj.quartzclusterdemo.entity.JobInfo;
import org.sxyxhj.quartzclusterdemo.service.JobScheduleService;

import java.util.List;

/**
 * @program: quartz-cluster-demo
 * @description:
 * @author: elroyh
 * @create: 2021-06-02 15:59
 **/

@RestController
@Api(value = "desc of class")
public class SchedulerController {


    @Autowired
    private JobScheduleService jobScheduleService;

    @Autowired
    private JobSchedulerManager jobSchedulerManager;

    //添加任务
    @PostMapping(value = "/add", produces = {"application/json"})
    @ApiOperation(value = "desc of method", notes = "")
    public String addJob(JobInfo jobInfo) throws Exception {

        jobSchedulerManager.addJob(jobInfo.getJobName(), jobInfo.getJobGroup(), jobInfo.getCronExpression());
        return "S";
    }
    //暂停任务
    @PostMapping(value = "/pause", produces = {"application/json"})
    @ApiOperation(value = "desc of method", notes = "")
    public String pauseJob(JobInfo jobInfo) throws Exception {

        jobSchedulerManager.pauseJob(jobInfo.getJobName(), jobInfo.getJobGroup());
        return "S";
    }
    //重启调度任务
    @PostMapping(value = "/resume", produces = {"application/json"})
    @ApiOperation(value = "desc of method", notes = "")
    public String resumeJob(JobInfo jobInfo) throws Exception {

        jobSchedulerManager.resumeJob(jobInfo.getJobName(), jobInfo.getJobGroup());
        return "S";
    }
    //修改任务
    @PostMapping(value = "/reschedule", produces = {"application/json"})
    @ApiOperation(value = "desc of method", notes = "")
    public String rescheduleJob(JobInfo jobInfo) throws Exception {

        jobSchedulerManager.rescheduleJob(jobInfo.getJobName(), jobInfo.getJobGroup(), jobInfo.getCronExpression());
        return "S";
    }
    //删除任务
    @PostMapping(value = "/delete", produces = {"application/json"})
    @ApiOperation(value = "desc of method", notes = "")
    public String deleteJob(JobInfo jobInfo) throws Exception {

        jobSchedulerManager.deleteJob(jobInfo.getJobName(), jobInfo.getJobGroup());
        return "S";
    }


    //立即触发任务
    @PostMapping(value = "/trigger", produces = {"application/json"})
    @ApiOperation(value = "desc of method", notes = "")
    public String triggerJob(JobInfo jobInfo) throws Exception {

        jobSchedulerManager.triggerJob(jobInfo.getJobName(), jobInfo.getJobGroup());
        return "S";
    }
    //调度任务查询
    @GetMapping(value = "/all", produces = {"application/json"})
    @ApiOperation(value = "desc of method", notes = "")
    public  List<JobInfo> getAllJob() throws Exception {

        List<JobInfo> list = jobScheduleService.getJobAndTriggerDetails();

        return list;
    }

}
