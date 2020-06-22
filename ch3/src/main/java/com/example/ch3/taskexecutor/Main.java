package com.example.ch3.taskexecutor;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	
	public static void main(String[] args) {
		 AnnotationConfigApplicationContext context =
	                new AnnotationConfigApplicationContext(TaskExecutorConfig.class);
		 
		 AsyncTaskService asyncTaskService = context.getBean(AsyncTaskService.class);

		 //执行异步方法，此处为并发执行而不是顺序执行
		 for(int i =0 ;i<10;i++){
			 asyncTaskService.executeAsyncTask(i);
			 asyncTaskService.executeAsyncTaskPlus(i);
		 }
		 context.close();
	}
}
