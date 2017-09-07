package com.atguigu.spring.aop.impl_xml;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class LoggingAspect {

	public void declareJointPointException(){}
	public void beforeMethod(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();// 返回调用的方法名
		List<Object> args = Arrays.asList(joinPoint.getArgs());// 获取参数
		System.out.println("The method " + methodName + " begins with " + args);
	}

	public void afterMethod(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();// 返回调用的方法名
		System.out.println("The method " + methodName + " ends");
	}

	public void afterReturning(JoinPoint joinpoint, Object result) {
		String methodName = joinpoint.getSignature().getName(); // 返回调用的方法名
		System.out.println("The method " + methodName + " afterReturning with " + result);
	}

	public void afterThrowing(JoinPoint joinPoint, Exception e) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method " + methodName + "occurs exception " + e);
	}

	public Object aroundMethod(ProceedingJoinPoint pjd) {
		Object result = null;
		String methodName = pjd.getSignature().getName();
		try {
			// 前置通知
			System.out.println("The method " + methodName + "begins with " + Arrays.asList(pjd.getArgs())); // 获得参数
			result = pjd.proceed(); // 执行目标方法
			// 返回通知
			System.out.println("The method " + methodName + " ends with " + result);
		} catch (Throwable e) {
			System.out.println("The method " + methodName + " occurs exception " + e);
			throw new RuntimeException(e);
		}
		// 后置通知
		System.out.println("The method " + methodName + " ends");
		return result;
	}

}
