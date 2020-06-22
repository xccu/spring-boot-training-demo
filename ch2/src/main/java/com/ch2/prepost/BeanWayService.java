package com.ch2.prepost;

//使用@Bean形式的Bean
public class BeanWayService {
	public void init(){
		System.out.println("@Bean-init-method");
	}

	public BeanWayService() {
		super();
		System.out.println("初始化的构造函数-BeanWayService");
	}

	public void destroy(){
		System.out.println("@Bean-destory-method");
	}
}
