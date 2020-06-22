package com.example.web.ch4_5;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

@Controller
public class SseController {

    //1.使用输出的媒体类型为text/event-stream，这是服务器端SSE的支持
	@RequestMapping(value="/push",produces="text/event-stream")
	public @ResponseBody String push(){
	    Random r = new Random();
        try {
            //每隔5秒钟向浏览器推送随机消息
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }   
        return "data:Testing 1,2,3" + r.nextInt() +"\n\n";
	}

}
