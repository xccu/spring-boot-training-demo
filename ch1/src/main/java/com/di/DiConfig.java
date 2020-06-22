package com.di;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration //1.@Configuration注解声明当前类是一个配置类
@ComponentScan("com.di") //2.@ComponentScan注解自动扫描对应包名下的所有service，component，repository和controller类，并注册为bean
public class DiConfig {

}
