package com.example.ch3.taskexecutor;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@ComponentScan("com.example.ch3.taskexecutor")
@EnableAsync //1.利用 @EnableAsync注解开启异步任务支持
public class TaskExecutorConfig implements AsyncConfigurer{//2.配置类实现AsyncConfigurer接口

	//3.重写AsyncConfigurer接口的getAsyncExecutor方法，并返回一个ThreadPoolTaskExecutor
	//这样我们就获得了一个基于线程池的TaskExecutor
	@Override
	public Executor getAsyncExecutor() {
		 ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
	        taskExecutor.setCorePoolSize(5);
	        taskExecutor.setMaxPoolSize(10);
	        taskExecutor.setQueueCapacity(25);
	        taskExecutor.initialize();
	        return taskExecutor;
	}

	@Override
	public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
		return null;
	}

}
