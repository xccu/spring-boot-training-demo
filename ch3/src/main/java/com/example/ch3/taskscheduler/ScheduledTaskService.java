package com.example.ch3.taskscheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

//计划任务执行类
@Service
public class ScheduledTaskService {
	
	  private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	  @Scheduled(fixedRate = 5000) //1.通过@Scheduled声明该方法是计划任务，使用fixedRate属性每隔固定时间（单位：毫秒）异步执行
	  public void reportCurrentTime() {
	       System.out.println("每隔五秒执行一次 " + dateFormat.format(new Date()));
	   }

	  @Scheduled(cron = "0 28 11 ? * *"  ) //2.使用cron属性按照指定的时间执行，本例为每天11点28分执行，cron是Unix和Linux系统下的定时任务
	  public void fixTimeExecution(){
	      System.out.println("在指定时间 " + dateFormat.format(new Date())+"执行");
	  }

}
