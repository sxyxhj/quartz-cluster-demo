package org.sxyxhj.quartzclusterdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sxyxhj.quartzclusterdemo.entity.JobInfo;
import org.sxyxhj.quartzclusterdemo.mapper.JobAndTriggerMapper;

import java.util.List;

/**
 * @program: quartz-cluster-demo
 * @description:
 * @author: elroyh
 * @create: 2021-06-02 16:56
 **/

@Service
public class JobScheduleServiceImpl implements JobScheduleService {

    @Autowired
    private JobAndTriggerMapper mapper;

    @Override
    public List<JobInfo> getJobAndTriggerDetails() {
        return mapper.getJobAndTriggerDetails();
    }
}
