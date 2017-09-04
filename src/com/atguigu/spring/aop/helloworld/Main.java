package com.atguigu.spring.aop.helloworld;

public class Main {
	public static void main(String[] args) {

		/**
		 * 没有代理的方式进行调用
		 */
		// ArithmeticCalculator arithmeticCalculator = new ArithmeticCalculatorImpl();
		// int result = arithmeticCalculator.add(1, 3);
		// System.out.println("==> " + result);
		// result = arithmeticCalculator.sub(1, 3);
		// System.out.println("==> " + result);
		
		ArithmeticCalculator target = new ArithmeticCalculatorImpl(); // 原对象
		ArithmeticCalculator proxy = new ArithmeticCalculatorLoggingProxy(target).getLoggingProxy(); // 代理对象
		
		int result = proxy.add(1, 3);
		System.out.println("==> " + result);
		result = proxy.sub(1, 3);
		System.out.println("==> " + result);
	}
}
