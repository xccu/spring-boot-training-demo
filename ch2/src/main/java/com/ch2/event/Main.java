package com.ch2.event;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(EventConfig.class);

		//事件发布类实例化
		DemoPublisher demoPublisher = context.getBean(DemoPublisher.class);
		//发布事件
		demoPublisher.publish("hello application event");
		 
		context.close();
	}
}
