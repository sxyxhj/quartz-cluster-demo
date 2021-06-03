package org.sxyxhj.quartzclusterdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = "org.sxyxhj.quartzclusterdemo.*")
public class QuartzClusterDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuartzClusterDemoApplication.class, args);
    }

}
