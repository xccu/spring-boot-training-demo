package com.wisely.ch7_4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.ErrorPage;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class Ch74Application {

    public static void main(String[] args) {
        SpringApplication.run(Ch74Application.class, args);
    }

    /**
     * 通用配置：通过静态内部类配置，必须声明为static
     */
    /*@Component
    public static class CustomServletContainer implements EmbeddedServletContainerCustomizer {

		@Override
		public void customize(ConfigurableEmbeddedServletContainer container) {
            //1.配置端口号
            container.setPort(8888);
            //2.配置错误页面，根据httpstatus错误状态信息，跳转到指定的错误页面
            container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/404.html"));
            //3.配置Servlet容器session过期时间
            container.setSessionTimeout(10,TimeUnit.MINUTES);
		}
    }*/

    /**
     * 特定配置：Tomcat
     * @return
     */
    /*@Bean
    public EmbeddedServletContainerFactory servletContainer() {
        TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory();
        //1.配置端口号
        factory.setPort(8888);
        //2.配置错误页面，根据httpstatus错误状态信息，跳转到指定的错误页面
        factory.setSessionTimeout(10, TimeUnit.MINUTES);
        //3.配置Servlet容器session过期时间
        factory.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/404.html"));
        return factory;
    }*/
    
    
//    @Bean
//    public EmbeddedServletContainerFactory servletContainer() {
//      TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory() {
//          @Override
//          protected void postProcessContext(Context context) {
//            SecurityConstraint securityConstraint = new SecurityConstraint();
//            securityConstraint.setUserConstraint("CONFIDENTIAL");
//            SecurityCollection collection = new SecurityCollection();
//            collection.addPattern("/*");
//            securityConstraint.addCollection(collection);
//            context.addConstraint(securityConstraint);
//          }
//        };
//      
//      tomcat.addAdditionalTomcatConnectors(httpConnector());
//      return tomcat;
//    }
//    @Bean
//    public Connector httpConnector() {
//      Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
//      connector.setScheme("http");
//      connector.setPort(8080);
//      connector.setSecure(false);
//      connector.setRedirectPort(8443);
//      return connector;
//    }
}
