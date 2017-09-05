package com.atguigu.spring.aop.impl;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(2)// 通过@order 注解来添加切面的优先级，数字越小，优先级越高
// 将这个声明的类放入到IOC容器中，同时还需要声明一个切面
@Aspect
@Component
public class LoggingAspect {

	// 前置通知
	// 声明一个前置通知，在目标方法之前执行
	@Before("execution(public int com.atguigu.spring.aop.impl.ArithmeticCalculatorImpl.*(int, int))")
	// JoinPoint : 连接点
	public void beforeMethod(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();// 返回调用的方法名
		List<Object> args = Arrays.asList(joinPoint.getArgs());// 获取参数
		System.out.println("The method " + methodName + " begins with " + args);
	}

	// 后置通知：在目标方法执行后（无论是否发生异常），执行通知
	// 后置通知中还不能访问目标方法执行的结果
	@After("execution(public int com.atguigu.spring.aop.impl.ArithmeticCalculatorImpl.*(int, int))")
	public void afterMethod(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();// 返回调用的方法名
		System.out.println("The method " + methodName + " ends");
	}

	/**
	 * 在方法正常结束后执行的代码 返回通知是可以访问到方法的返回值
	 */
	@AfterReturning(value = "execution(public int com.atguigu.spring.aop.impl.ArithmeticCalculatorImpl.*(int, int))", returning = "result")
	public void afterReturning(JoinPoint joinpoint, Object result) {
		String methodName = joinpoint.getSignature().getName(); // 返回调用的方法名
		System.out.println("The method " + methodName + " afterReturning with " + result);
	}

	/**
	 * 异常通知： 在目标出现异常时会执行的代码。 可以访问到异常对象，且可以指定在出现异常时再执行通知代码
	 */
	@AfterThrowing(value = "execution(public int com.atguigu.spring.aop.impl.ArithmeticCalculatorImpl.*(int, int))", throwing = "e")
	public void afterThrowing(JoinPoint joinPoint, Exception e) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method " + methodName + "occurs exception " + e);
	}

	/**
	 * 环绕通知 环绕通知需要携带 ProceedingJoinPoint 类型的参数
	 * 环绕通知类似于动态代理的全过程：ProceedingJoinPoint 可以决定是否执行目标方法
	 * 且环绕通知必须要有返回值，返回值即为目标方法的返回值
	 */
	@Around("execution(public int com.atguigu.spring.aop.impl.ArithmeticCalculatorImpl.*(int, int))")
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
