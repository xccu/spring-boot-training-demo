package com.wisely.ch7_4;

import java.util.concurrent.TimeUnit;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.ErrorPage;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class CustomServletContainer implements EmbeddedServletContainerCustomizer{

	@Override
	public void customize(ConfigurableEmbeddedServletContainer container) {
/*		//1.配置端口号
		container.setPort(8888);
		//2.配置错误页面，根据httpstatus错误状态信息，跳转到指定的错误页面
		container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/404.html"));
		//3.配置Servlet容器session过期时间
		container.setSessionTimeout(10,TimeUnit.MINUTES);
		*/
	}

}
