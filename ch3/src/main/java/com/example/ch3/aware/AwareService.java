package com.example.ch3.aware;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class AwareService implements BeanNameAware,ResourceLoaderAware{//1.实现BeanNameAware，ResourceLoaderAware接口，获得Bean名称和资源加载的服务
	
	private String beanName;
	private ResourceLoader loader;

	//2.实现ResourceLoaderAware需要重写setResourceLoader
	@Override
	public void setResourceLoader(ResourceLoader resourceLoader) {//2
		this.loader = resourceLoader;
	}

	//3.实现BeanNameAware需要重写setBeanName方法
	@Override
	public void setBeanName(String name) {//3
		this.beanName = name;
	}
	
	public void outputResult(){
		System.out.println("Bean的名称为：" + beanName);
		
		Resource resource = loader.getResource("classpath:com/example/ch3/aware/test.txt");
		try{
			
			System.out.println("ResourceLoader加载的文件内容为: " + IOUtils.toString(resource.getInputStream()));
			
		   }catch(IOException e){
			e.printStackTrace();
		   }
	
	}

}
