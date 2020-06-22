package com.di;

import org.springframework.stereotype.Service;

@Service //1.@Service注解声明UseFunctionService类是spring管理的一个bean
public class FunctionService {
	public String sayHello(String word){
		return "Hello " + word +" !"; 
	}

}
