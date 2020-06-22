package com.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

//�Զ�������
@Aspect		//1.Aspectע������һ������
@Component	//2.�������Ϊspring���������bean
public class LogAspect {
	
	@Pointcut("@annotation(com.aop.Action)") 					//3.Pointcutע�������е�
	public void annotationPointCut(){};
	
	  @After("annotationPointCut()") 							//4.Afterע������һ�����ԣ���ʹ��Pointcut������е�
	    public void after(JoinPoint joinPoint) {
	        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
	        Method method = signature.getMethod();
	        Action action = method.getAnnotation(Action.class); 
	        System.out.println("ע��ʽ���� " + action.name()); 	//5.�����ȡע�������
	    }
	  
	   @Before("execution(* com.aop.DemoMethodService.*(..))") 	//6.Beforeע���������ԣ�ʹ�����ع�����Ϊ����
	    public void before(JoinPoint joinPoint){
	        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
	        Method method = signature.getMethod();
	        System.out.println("��������ʽ����,"+method.getName());

	    }
}
