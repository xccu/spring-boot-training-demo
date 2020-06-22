package com.example.ch3.taskexecutor;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

//任务执行类
@Service
public class AsyncTaskService {

    //1.通过@Async注解表明该方法为异步方法，如果注解在类级别，表明此类所有方法都是异步方法
    //这里的异步方法自动被注入使用ThreadPoolTaskExecutor作为TaskExecutor
	@Async
    public void executeAsyncTask(Integer i){
        System.out.println("执行异步任务: "+i);
    }

    @Async
    public void executeAsyncTaskPlus(Integer i){
        System.out.println("执行异步任务+1: "+(i+1));
    }

}
