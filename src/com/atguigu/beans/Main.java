package com.atguigu.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	
	public static void main(String[] args) {
		
/*		HelloWorld helloWorld = new HelloWorld();
		helloWorld.setName("atguigu");*/
		
		// 1、创建Spring的ioc容器对象
		// 主要执行调用bean的构造方法并调用属性的set方法
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// 2、从ioc容器中获取bean实例
		HelloWorld helloWorld = (HelloWorld) applicationContext.getBean("helloWorld");
		// 3、调用hello方法
		helloWorld.hello();
	}
}
