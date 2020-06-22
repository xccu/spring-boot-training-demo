package com.example.web.ch4_3;

import com.example.domain.DemoObj;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller //1.注解声明为一个控制器
@RequestMapping("/anno") //2.映射此类的访问路径为/anno
public class DemoAnnoController {

	//3.此方法未标注路径，默认为/anno
	//produces可定制返回的Response的媒体类型和字符集
	//如果需要返回值是json对象，则设置produces = "json;charset=UTF-8"
	@RequestMapping(produces = "text/plain;charset=UTF-8")
	//4.演示可接受HttpServletRequest为参数,当然也可以接受HttpServletResponse，此处的@ResponseBody用在返回值前面
	public @ResponseBody String index(HttpServletRequest request) {
		return "url:" + request.getRequestURL() + " can access";
	}

	//5.演示可接受路径为参数,并在方法参数前结合@PathVariable使用,访问路径为/anno/pathvar/{str}
	@RequestMapping(value = "/pathvar/{str}", produces = "text/plain;charset=UTF-8")
	public @ResponseBody String demoPathVar(@PathVariable String str, HttpServletRequest request) {
		return "url:" + request.getRequestURL() + " can access,str: " + str;
	}

	//6.演示常规的request参数获取，访问路径为/anno/requestParam?id=1
	@RequestMapping(value = "/requestParam", produces = "text/plain;charset=UTF-8")
	public @ResponseBody String passRequestParam(Long id, HttpServletRequest request) {
		
		return "url:" + request.getRequestURL() + " can access,id: " + id;

	}

	//7.演示解释参数到对象，访问路径为/anno/obj?id=1&name=xx
	@RequestMapping(value = "/obj", produces = "application/json;charset=UTF-8")
	@ResponseBody //8.@ResponseBody注解也可用在方法上
	public String passObj(DemoObj obj, HttpServletRequest request) {
		
		 return "url:" + request.getRequestURL() 
		 			+ " can access, obj id: " + obj.getId()+" obj name:" + obj.getName();

	}

	//9.演示映射不同路径到相同的方法，访问路径为/anno/name1或/anno/name2
	@RequestMapping(value = { "/name1", "/name2" }, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String remove(HttpServletRequest request) {
		
		return "url:" + request.getRequestURL() + " can access";
	}

}
