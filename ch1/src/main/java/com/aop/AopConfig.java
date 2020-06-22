package com.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

//配置类
@Configuration
@ComponentScan("com.aop")
@EnableAspectJAutoProxy //1.EnableAspectJAutoProxy注解开启Spring对AspectJ的支持
public class AopConfig {

}
