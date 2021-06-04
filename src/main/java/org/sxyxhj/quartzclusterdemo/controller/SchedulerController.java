package org.sxyxhj.quartzclusterdemo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.sxyxhj.quartzclusterdemo.component.JobSchedulerManager;
import org.sxyxhj.quartzclusterdemo.entity.JobInfo;
import org.sxyxhj.quartzclusterdemo.entity.JsonEntity;
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
    public JsonEntity addJob(JobInfo jobInfo){

        boolean result = jobSchedulerManager.addJob(jobInfo.getJobName(), jobInfo.getJobGroup(), jobInfo.getCronExpression());

        if(result){
            return new JsonEntity(HttpStatus.OK.value(),"");
        }else{
            return new JsonEntity(HttpStatus.INTERNAL_SERVER_ERROR.value(),"Add job failed");
        }
    }
    //暂停任务
    @PostMapping(value = "/pause", produces = {"application/json"})
    @ApiOperation(value = "desc of method", notes = "")
    public JsonEntity pauseJob(JobInfo jobInfo) {

        boolean result = jobSchedulerManager.pauseJob(jobInfo.getJobName(), jobInfo.getJobGroup());
        if(result){
            return new JsonEntity(HttpStatus.OK.value(),"");
        }else{
            return new JsonEntity(HttpStatus.INTERNAL_SERVER_ERROR.value(),"Pause job failed");
        }
    }
    //重启调度任务
    @PostMapping(value = "/resume", produces = {"application/json"})
    @ApiOperation(value = "desc of method", notes = "")
    public JsonEntity resumeJob(JobInfo jobInfo) {

        boolean result = jobSchedulerManager.resumeJob(jobInfo.getJobName(), jobInfo.getJobGroup());
        if(result){
            return new JsonEntity(HttpStatus.OK.value(),"");
        }else{
            return new JsonEntity(HttpStatus.INTERNAL_SERVER_ERROR.value(),"Resume job failed");
        }
    }
    //修改任务
    @PostMapping(value = "/reschedule", produces = {"application/json"})
    @ApiOperation(value = "desc of method", notes = "")
    public JsonEntity rescheduleJob(JobInfo jobInfo){

        boolean result = jobSchedulerManager.rescheduleJob(jobInfo.getJobName(), jobInfo.getJobGroup(), jobInfo.getCronExpression());
        if(result){
            return new JsonEntity(HttpStatus.OK.value(),"");
        }else{
            return new JsonEntity(HttpStatus.INTERNAL_SERVER_ERROR.value(),"Reschedule job failed");
        }
    }
    //删除任务
    @PostMapping(value = "/delete", produces = {"application/json"})
    @ApiOperation(value = "desc of method", notes = "")
    public JsonEntity deleteJob(JobInfo jobInfo) {

        boolean result = jobSchedulerManager.deleteJob(jobInfo.getJobName(), jobInfo.getJobGroup());
        if(result){
            return new JsonEntity(HttpStatus.OK.value(),"");
        }else{
            return new JsonEntity(HttpStatus.INTERNAL_SERVER_ERROR.value(),"Delete job failed");
        }
    }


    //立即触发任务
    @PostMapping(value = "/trigger", produces = {"application/json"})
    @ApiOperation(value = "desc of method", notes = "")
    public JsonEntity triggerJob(JobInfo jobInfo) {

        boolean result = jobSchedulerManager.triggerJob(jobInfo.getJobName(), jobInfo.getJobGroup());
        if(result){
            return new JsonEntity(HttpStatus.OK.value(),"");
        }else{
            return new JsonEntity(HttpStatus.INTERNAL_SERVER_ERROR.value(),"Trigger job failed");
        }
    }
    //调度任务查询
    @GetMapping(value = "/all", produces = {"application/json"})
    @ApiOperation(value = "desc of method", notes = "")
    public List<JobInfo> getAllJob() {

        List<JobInfo> list = jobScheduleService.getJobAndTriggerDetails();

        return list;
    }

}
