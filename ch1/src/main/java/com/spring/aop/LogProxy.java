package com.spring.aop;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogProxy {

    /*@Before("execution(public int com.spring.aop.ArithmeticCalculator.*(int, int))")
    public void beforMethod(JoinPoint point){
        String methodName = point.getSignature().getName();
        List<Object> args = Arrays.asList(point.getArgs());
        System.out.println("调用前连接点方法为：" + methodName + ",参数为：" + args);
    }*/

    /*@After(("execution(public int com.spring.aop.ArithmeticCalculator.*(int, int))"))
    public void afterMethod(JoinPoint point){
        String methodName = point.getSignature().getName();
        List<Object> args = Arrays.asList(point.getArgs());
        System.out.println("调用后连接点方法为：" + methodName + ",参数为：" + args);
    }*/

    //通过returning属性指定连接点方法返回的结果放置在result变量中，
    //在返回通知方法中可以从result变量中获取连接点方法的返回结果了。
    @AfterReturning(value="execution(public int com.spring.aop.ArithmeticCalculator.*(int, int))",
            returning="result")
    public void afterReturning(JoinPoint point, Object result){
        String methodName = point.getSignature().getName();
        List<Object> args = Arrays.asList(point.getArgs());
        System.out.println("连接点方法为：" + methodName + ",参数为："
                + args + ",目标方法执行结果为：" + result);
    }

}
