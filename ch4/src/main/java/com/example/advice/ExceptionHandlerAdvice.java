package com.example.advice;

import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice //1.@ControllerAdvice注解声明控制器建言，组合了@Component注解，可自动注册为Bean
public class ExceptionHandlerAdvice {

	//2.ExceptionHandler在此处定义全局处理，通过ExceptionHandler的value属性可过滤拦截条件，此处拦截所有Exception
	@ExceptionHandler(value = Exception.class)
	public ModelAndView exception(Exception exception, WebRequest request) {
		ModelAndView modelAndView = new ModelAndView("error");// error页面
		modelAndView.addObject("errorMessage", exception.getMessage());
		return modelAndView;
	}

	//3.使用@ModelAttribute注解将键值对添加到全局，所有注解@RequestMapping的方法可获得此键值对
	@ModelAttribute
	public void addAttributes(Model model) {
		model.addAttribute("msg", "额外信息");
	}

	//4.通过@InitBinder 注解定制initBinder
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		//5.此处演示忽略request参数的id,所有请求中的对象参数中id字段都将无法获取
		//webDataBinder.setDisallowedFields("id");
	}
}
