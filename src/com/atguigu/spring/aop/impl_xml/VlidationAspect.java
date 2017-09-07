package com.atguigu.spring.aop.impl_xml;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;

public class VlidationAspect {
	public void vlidationAspect(JoinPoint joinpoint){
		System.out.println(" --> vlidationAspect : " + Arrays.asList(joinpoint.getArgs()));
	}
}
