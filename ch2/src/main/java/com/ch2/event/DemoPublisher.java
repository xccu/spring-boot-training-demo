package com.ch2.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

//事件发布类
@Component
public class DemoPublisher {
	@Autowired
	ApplicationContext applicationContext; //1.注入ApplicationContext用来发布事件
	
	public void publish(String msg){
		//2.使用applicationContext的publishEvent方法来发布DemoEvent事件
		applicationContext.publishEvent(new DemoEvent(this, msg));
	}

}
