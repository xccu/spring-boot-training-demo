package com.aop;

import java.lang.annotation.*;

//自定义拦截规则的注解
@Target(ElementType.METHOD) //注解所修饰的对象范围，此处为方法级
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Action {
    String name();
}
