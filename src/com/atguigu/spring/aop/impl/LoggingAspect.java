package com.atguigu.spring.aop.impl;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

// 将这个声明的类放入到IOC容器中，同时还需要声明一个切面
@Aspect
@Component
public class LoggingAspect {

	// 前置通知
	// 声明一个前置通知，在目标方法之前执行
	@Before("execution(public int com.atguigu.spring.aop.impl.ArithmeticCalculatorImpl.*(int, int))")
	// JoinPoint : 连接点
	public void beforeMethod(JoinPoint joinPoint){
		String methodName = joinPoint.getSignature().getName();// 返回调用的方法名
		List<Object> args = Arrays.asList(joinPoint.getArgs());// 获取参数 
		System.out.println("The method " + methodName +" begins with " + args);
	}
	
	
	// 后置通知：在目标方法执行后（无论是否发生异常），执行通知
	// 后置通知中还不能访问目标方法执行的结果
	@After("execution(public int com.atguigu.spring.aop.impl.ArithmeticCalculatorImpl.*(int, int))")
	public void afterMethod(JoinPoint joinPoint){
		String methodName = joinPoint.getSignature().getName();// 返回调用的方法名
		System.out.println("The method " + methodName +" ends");
	}
	
	
	
}
