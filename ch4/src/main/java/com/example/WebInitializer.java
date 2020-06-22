package com.example;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

//Web初始化类
//1.WebApplicationInitializer接口是spring提供用来配置servlet3.0+配置的接口，实现了替代web.xml的位置
//实现此接口会自动被SpringServletContainerInitializer（用于启动servlet3.0容器）获取到
public class WebInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(MyMvcConfig.class);
        //2.新建WebApplicationContext,注册配置类，并将其和当前servletContext关联
        ctx.setServletContext(servletContext);

        //3.注册springMVC的DispatcherServlet,会自动扫描注解为Controller的类
        Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(ctx));
        servlet.addMapping("/");
        servlet.setLoadOnStartup(1);
        servlet.setAsyncSupported(true);//1.servlet开启异步方法支持

	}

}
