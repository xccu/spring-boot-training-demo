package com.example.web.ch4_2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller//1.注解声明为一个控制器
public class HelloController {

	//在MyMvcConfig中实现addViewControllers添加后，此处可以省略
	@RequestMapping("/index")//2.利用@RequestMapping配置url和方法之间的映射
	public String hello(){
		return "index";
	}

}
