package org.sxyxhj.quartzclusterdemo.config;

import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.ee.servlet.QuartzInitializerListener;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import java.io.IOException;
import java.util.Properties;

/**
 * @program: quartz-cluster-demo
 * @description: 配置类，加载配置文件
 * @author: elroyh
 * @create: 2021-06-02 15:21
 **/

@Configuration
public class SchedulerConfig {


    // 加载配置文件
    @Bean
    public Properties getQuartzProperties() throws IOException {

        PropertiesFactoryBean factoryBean = new PropertiesFactoryBean();
        factoryBean.setLocation(new ClassPathResource("quartz.properties"));

        factoryBean.afterPropertiesSet();
        return factoryBean.getObject();
    }

    @Bean(name = "SchedulerFactory")
    public SchedulerFactoryBean createSchedulerFactoryBean() throws IOException {
        SchedulerFactoryBean factory = new SchedulerFactoryBean();
        factory.setQuartzProperties(getQuartzProperties());
        return factory;
    }

    @Bean(name = "Scheduler")
    public Scheduler scheduler() throws IOException {
        return createSchedulerFactoryBean().getScheduler();
    }

    /*@Bean
    public QuartzInitializerListener initializerListener(){
        return new QuartzInitializerListener();
    }
*/
}
