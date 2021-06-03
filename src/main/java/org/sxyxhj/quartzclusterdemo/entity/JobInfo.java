package org.sxyxhj.quartzclusterdemo.entity;

import lombok.Data;

/**
 * @program: quartz-cluster-demo
 * @description:
 * @author: elroyh
 * @create: 2021-06-02 15:53
 **/

@Data
public class JobInfo {
    String jobName;
    String jobGroup;
    String cronExpression;
}

