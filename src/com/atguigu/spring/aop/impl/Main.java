package com.atguigu.spring.aop.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {

		// 创建spring IOC 容器
		ApplicationContext context = new ClassPathXmlApplicationContext("aop-applicationContext.xml");

		// 从IOC容器中获取bean实例
		ArithmeticCalculator arithmeticCalculator = context.getBean(ArithmeticCalculator.class);
		
		// 使用bean
		int result = arithmeticCalculator.add(2, 4);
		System.out.println("result : " + result);
		
		result = arithmeticCalculator.div(4, 2);
		System.out.println("result : " + result);
	}

}
