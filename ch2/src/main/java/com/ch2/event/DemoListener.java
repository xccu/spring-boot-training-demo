package com.ch2.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

//事件监听器
//1.实现ApplicationListener接口,并指定监听的事件类型为DemoEvent
@Component
public class DemoListener implements ApplicationListener<DemoEvent> {

	//2.使用onApplicationEvent方法对消息进行接受处理
	public void onApplicationEvent(DemoEvent event) {
		
		String msg = event.getMsg();

		System.out.println("我(bean-demoListener)接收到了bean-demoPublisher发布的消息:"
				+ msg);

	}

}
