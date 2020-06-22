package com.example.ch3.annotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.lang.annotation.*;

@Target(ElementType.TYPE) //1.注解作用的位置，ElementType.TYPE表示该注解能作用于类、接口(包括注解类型) 或enum声明
@Retention(RetentionPolicy.RUNTIME) //2.注解的生命周期，表示注解会被保留到什么阶段，可以选择编译阶段、类加载阶段，或运行阶段
@Documented  //3.注解信息会被添加到Java文档中
@Configuration //4.组合@Configuration元注解
@ComponentScan //5.组合@ComponentScan元注解
public @interface WiselyConfiguration {
	String[] value() default {}; //6.覆盖value参数
}
