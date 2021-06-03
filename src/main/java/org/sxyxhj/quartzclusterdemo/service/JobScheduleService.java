package org.sxyxhj.quartzclusterdemo.service;

import org.sxyxhj.quartzclusterdemo.entity.JobInfo;

import java.util.List;

/**
 * @program: quartz-cluster-demo
 * @description:
 * @author: elroyh
 * @create: 2021-06-02 16:54
 **/

public interface JobScheduleService {
    List<JobInfo> getJobAndTriggerDetails();
}
