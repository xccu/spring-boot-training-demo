package com.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

//自定义切面
@Aspect		//1.Aspect注解声明一个切面
@Component	//2.让切面成为spring容器管理的bean
public class LogAspect {
	
	@Pointcut("@annotation(com.aop.Action)") 					//3.Pointcut注解声明切点
	public void annotationPointCut(){};
	
	  @After("annotationPointCut()") 							//4.After注解声明一个建言，并使用Pointcut定义的切点
	    public void after(JoinPoint joinPoint) {
	        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
	        Method method = signature.getMethod();
	        Action action = method.getAnnotation(Action.class); 
	        System.out.println("注解式拦截 " + action.name()); 	//5.反射获取注解的属性
	    }
	  
	   @Before("execution(* com.aop.DemoMethodService.*(..))") 	//6.Before注解声明建言，使用拦截规则作为参数
	    public void before(JoinPoint joinPoint){
	        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
	        Method method = signature.getMethod();
	        System.out.println("方法规则式拦截,"+method.getName());

	    }
}
