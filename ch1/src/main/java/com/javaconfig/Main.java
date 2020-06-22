package com.javaconfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	public static void main(String[] args) {

		//1.使用AnnotationConfigApplicationContext作为spring容器，接受输入一个配置类作为参数
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
		 
		UseFunctionService useFunctionService = context.getBean(UseFunctionService.class);

		//useFunctionService.setFunctionService();
		System.out.println(useFunctionService.SayHello("java config"));

		context.close();
	}
}
