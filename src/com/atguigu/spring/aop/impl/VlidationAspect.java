package com.atguigu.spring.aop.impl;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Aspect
@Component
public class VlidationAspect {
	@Before("execution(public int com.atguigu.spring.aop.impl.ArithmeticCalculatorImpl.*(..))")
	public void vlidationAspect(JoinPoint joinpoint){
		System.out.println(" --> vlidationAspect : " + Arrays.asList(joinpoint.getArgs()));
	}
}
