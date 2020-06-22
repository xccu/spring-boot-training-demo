package com.example.ch3.taskscheduler;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@ComponentScan("com.example.ch3.taskscheduler")
@EnableScheduling //1.通过@EnableScheduling注解开启对计划任务的支持
public class TaskSchedulerConfig {

}
