package org.sxyxhj.quartzclusterdemo.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

/**
 * @program: quartz-cluster-demo
 * @description:
 * @author: elroyh
 * @create: 2021-06-02 16:11
 **/

public class MyJob implements Job {
    @Override
    public void execute(JobExecutionContext context) {

        System.err.println(getAddress() + " " + getDate() + "====>"+context.getJobDetail().getKey().getName()+"<====");

    }

    public static String getDate() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

    public static String getAddress() {
        return "http://localhost:" + ResourceBundle.getBundle("application").getString("server.port");
    }
}
