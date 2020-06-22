package com.example.web.ch4_4;

import com.example.domain.DemoObj;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdviceController {
	@RequestMapping("/advice")
	public String getSomething(@ModelAttribute("msg") String msg,DemoObj obj){//1
		throw new IllegalArgumentException("非常抱歉，参数有误/"+"来自@ModelAttribute:"+ msg);
	}

	//此处参数id被initBinder忽略，将会抛错
	@RequestMapping("/exception")
	public String exception(@ModelAttribute("msg") String msg,DemoObj obj){
		 return obj.getId().toString();
	}

}
