package com.atguigu.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	
	public static void main(String[] args) {
		
/*		HelloWorld helloWorld = new HelloWorld();
		helloWorld.setName("atguigu");*/
		
		// 1������Spring��ioc��������
		// ��Ҫִ�е���bean�Ĺ��췽�����������Ե�set����
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// 2����ioc�����л�ȡbeanʵ��
		HelloWorld helloWorld = (HelloWorld) applicationContext.getBean("helloWorld");
		// 3������hello����
		helloWorld.hello();
	}
}
