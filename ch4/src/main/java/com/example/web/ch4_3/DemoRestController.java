package com.example.web.ch4_3;

import com.example.domain.DemoObj;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//1.@RestController注解声明为一个控制器，并且返回数据时不需要@ResponseBody
@RestController
@RequestMapping("/rest")
public class DemoRestController {

	//2.返回数据的媒体类型为json
	@RequestMapping(value = "/getjson", produces={"application/json;charset=UTF-8"})
	public DemoObj getjson (DemoObj obj){
		//3.直接返回对象，对象会自动转换成json
		return new DemoObj(obj.getId()+1, obj.getName()+"yy");
	}

	//4.返回数据的媒体类型为xml
	@RequestMapping(value = "/getxml", produces={"application/xml;charset=UTF-8"})
	public DemoObj getxml(DemoObj obj){
		//5.直接返回对象，对象会自动转换成xml
		return new DemoObj(obj.getId()+1, obj.getName()+"yy");
	}

}
