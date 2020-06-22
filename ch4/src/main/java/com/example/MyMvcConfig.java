package com.example;

import com.example.interceptor.DemoInterceptor;
import com.example.messageconverter.MyMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.util.List;

//springMVC配置类
@Configuration
@EnableWebMvc			// 1.开启springMVC支持，若无此注解，重写WebMvcConfigurerAdapter方法无效
@EnableScheduling		//开启计划任务支持
@ComponentScan("com.example")
public class MyMvcConfig extends WebMvcConfigurerAdapter { //2.继承WebMvcConfigurerAdapter类,重写其方法对springMVC进行配置

	@Bean
	public InternalResourceViewResolver viewResolver() {
		//ViewResolver是springMVC视图渲染的核心机制
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/classes/views/");
		viewResolver.setSuffix(".jsp");
		viewResolver.setViewClass(JstlView.class);
		return viewResolver;
	}

	//添加静态资源访问配置
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {

		// 3.addResourceLocations指文件放置的目录
		// addResourceHandler指对外暴露的访问路径
		registry.addResourceHandler("/assets/**")
				.addResourceLocations("classpath:/assets/");

	}

	// 1.配置拦截器的Bean
	@Bean
	public DemoInterceptor demoInterceptor() {
		return new DemoInterceptor();
	}

	//2.重写addInterceptors方法，注册拦截器
	@Override
	public void addInterceptors(InterceptorRegistry registry) {// 2
		registry.addInterceptor(demoInterceptor());
	}

	//自动添加简单的ViewController（不实现任何功能）
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/index").setViewName("/index");
		registry.addViewController("/toUpload").setViewName("/upload");
		registry.addViewController("/converter").setViewName("/converter");
		registry.addViewController("/sse").setViewName("/sse");
		registry.addViewController("/async").setViewName("/async");
	}

	//路径匹配参数配置
	@Override
	public void configurePathMatch(PathMatchConfigurer configurer) {
		//不忽略url中的"."
		configurer.setUseSuffixPatternMatch(false);
	 }

	@Bean
	public MultipartResolver multipartResolver() {
		//文件上传配置，最大上限1000000B
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setMaxUploadSize(1000000);
		return multipartResolver;
	}

	//添加自定义的HttpMessageConverter，不会覆盖Spring MVC默认的HttpMessageConverter
	@Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(converter());
    }

	//如果使用configMessageConverters会覆盖掉pring MVC默认的HttpMessageConverter，不推荐
	/*@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters){
		converters.add(converter());
	}*/

    //注册自定义的HttpMessageConverter为一个Bean
	@Bean 
	public MyMessageConverter converter(){
		return new MyMessageConverter();
	}

	

}
