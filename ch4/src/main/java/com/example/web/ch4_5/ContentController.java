package com.example.web.ch4_5;

import com.example.domain.DemoObj;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ContentController {
    @RequestMapping(value = "/getdemo")
    public String getDemo(Model model){
        DemoObj demoObj = new DemoObj(333l, "WYF");
        model.addAttribute("demoObj",demoObj);
        return "demoObj";

    }

}
