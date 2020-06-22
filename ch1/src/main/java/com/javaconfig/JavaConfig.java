package com.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //1.@Configuration注解表明当前类是一个配置类
public class JavaConfig {

	@Bean //2.@Bean注解声明当前方法是一个方法FunctionService返回值是一个bean，bean的名称就是方法名
	public FunctionService functionService(){
		return new FunctionService();
	}
	
	@Bean
	public UseFunctionService useFunctionService(){
		UseFunctionService useFunctionService = new UseFunctionService();
		//3.注入FunctionService的bean的时候直接调用functionService
		useFunctionService.setFunctionService(functionService());
		return useFunctionService;
	}

/*	@Bean
	public UseFunctionService useFunctionService(FunctionService functionService){//4.另一种注解方式，直接将FunctionService作为参数传给useFunctionService()
		UseFunctionService useFunctionService = new UseFunctionService();
		useFunctionService.setFunctionService(functionService);
		return useFunctionService;
	}*/
}
