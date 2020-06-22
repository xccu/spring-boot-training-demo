package com.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service //1.@Service注解声明UseFunctionService类是spring管理的一个bean
public class UseFunctionService {
	@Autowired //2.@Autowired注解将FunctionService的实体bean注入到UseFunctionService中
	FunctionService functionService;
	
	public String SayHello(String word){
		return functionService.sayHello(word);
	}

}
