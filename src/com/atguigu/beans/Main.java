package com.atguigu.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	
	public static void main(String[] args) {
		
/*		HelloWorld helloWorld = new HelloWorld();
		helloWorld.setName("atguigu");*/
		
		// 1������Spring��ioc��������
		// ��Ҫִ�е���bean�Ĺ��췽�����������Ե�set����
		// ApplicationContext ����IOC ����
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// 2����ioc�����л�ȡbeanʵ��
		// ����id��λ��IOC�����е�bean
		HelloWorld helloWorld = (HelloWorld) applicationContext.getBean("helloWorld");
		// ͨ�����ַ�ʽ���л�ȡbeanʵ���Ļ�ֱ��������bean�����ͣ�������������ͬ������bean�ͻ�����쳣
		// �������ͷ���IOC�����е�bean��Ҫ��IOC�����б���ֻ����һ�������͵�bean
		// HelloWorld helloWorld = applicationContext.getBean(HelloWorld.class);
		// 3������hello����
		helloWorld.hello();
		
		
		
		
		Car car = (Car) applicationContext.getBean("car");
		System.out.println(car.toString());
		
		car = (Car) applicationContext.getBean("cart");
		System.out.println(car.toString());
		
		
		
		Person person = (Person) applicationContext.getBean("person");
		System.out.println(person);
		
	}
}
