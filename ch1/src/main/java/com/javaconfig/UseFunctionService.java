package com.javaconfig;

//1使用功能类的bean
public class UseFunctionService {

	FunctionService functionService;

	//通过set方法注入
	public void setFunctionService(FunctionService functionService) {
		this.functionService = functionService;
	}
	
	public String SayHello(String word){
		return functionService.sayHello(word);
	}

}
