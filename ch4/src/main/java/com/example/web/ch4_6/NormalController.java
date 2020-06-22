package com.example.web.ch4_6;

import com.example.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//用于测试的controller
@Controller
public class NormalController {
	@Autowired
	DemoService demoService;
	

	
	@RequestMapping("/normal")
	public  String testPage(Model model){
		model.addAttribute("msg", demoService.saySomething());
		return "page";
	}

}
