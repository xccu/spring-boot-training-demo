package com.example.web.ch4_5;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class UploadController {
	
	@RequestMapping(value = "/upload",method = RequestMethod.POST)
	public @ResponseBody String upload(MultipartFile file) {//1.使用MultipartFile接受上传的文件
		
			try {
				//2.使用FileUtils.writeByteArrayToFile快速写文件到磁盘
				//上传到E:/upload目录下
				FileUtils.writeByteArrayToFile(
						new File("E:/upload/"+file.getOriginalFilename()), file.getBytes());
				return "ok";
			} catch (IOException e) {
				e.printStackTrace();
				return "wrong";
			}
			
		
	}

}
