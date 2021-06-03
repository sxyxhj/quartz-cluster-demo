package org.sxyxhj.quartzclusterdemo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.sxyxhj.quartzclusterdemo.entity.JobInfo;

import java.util.List;

/**
 * @program: quartz-cluster-demo
 * @description:
 * @author: elroyh
 * @create: 2021-06-03 11:13
 **/

@Component
@Mapper
public interface JobAndTriggerMapper {
    List<JobInfo> getJobAndTriggerDetails();
}
