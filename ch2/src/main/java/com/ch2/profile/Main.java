package com.ch2.profile;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		  AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

		  //1.先将活动的profile设置为dev
		  context.getEnvironment().setActiveProfiles("dev");

		  //2.后置注册Bean配置类
		  context.register(ProfileConfig.class);

		  //3.刷新容器
		  context.refresh();
		  
	      DemoBean demoBean = context.getBean(DemoBean.class);
	      
	      System.out.println(demoBean.getContent());
	      
	      context.close();
	}
}
