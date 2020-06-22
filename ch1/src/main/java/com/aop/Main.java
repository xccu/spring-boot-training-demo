package com.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	public static void main(String[] args) {
		//1.获取AOP的注解配置
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopConfig.class); //1

		 //反射获取注解的被拦截类
		 DemoAnnotationService demoAnnotationService = context.getBean(DemoAnnotationService.class);

		 //反射获取方法规则被拦截类
		 DemoMethodService demoMethodService = context.getBean(DemoMethodService.class);

		 //调用add方法
		 demoAnnotationService.add();
		 
		 demoMethodService.add();
		 
		 context.close();
	}

}
