package com.spring.aop;

import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        //加载xml文件
        ApplicationContext ctx = new ClassPathXmlApplicationContext("bean-aop.xml");
        //获得Spring中定义的Bean
        ArithmeticCalculator arithmetic = (ArithmeticCalculator) ctx.getBean("arithmeticCalculator");
        /*arithmetic.add(3, 2);
        arithmetic.div(4, 2);*/

        arithmetic.add(3, 2);
        /*被除数为0,会抛出异常*/
        arithmetic.div(4, 0);
    }
}
