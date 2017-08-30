package com.atguigu.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	
	public static void main(String[] args) {
		
/*		HelloWorld helloWorld = new HelloWorld();
		helloWorld.setName("atguigu");*/
		
		// 1、创建Spring的ioc容器对象
		// 主要执行调用bean的构造方法并调用属性的set方法
		// ApplicationContext 代表IOC 容器
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// 2、从ioc容器中获取bean实例
		// 利用id定位到IOC容器中的bean
		HelloWorld helloWorld = (HelloWorld) applicationContext.getBean("helloWorld");
		// 通过此种方式进行获取bean实例的话直接限制了bean的类型，假如有两个相同类名的bean就会出现异常
		// 利用类型返回IOC容器中的bean，要求IOC容器中必须只能有一个该类型的bean
		// HelloWorld helloWorld = applicationContext.getBean(HelloWorld.class);
		// 3、调用hello方法
		helloWorld.hello();
		
		
		
		
		Car car = (Car) applicationContext.getBean("car");
		System.out.println(car.toString());
		
		car = (Car) applicationContext.getBean("cart");
		System.out.println(car.toString());
		
		
		
		Person person = (Person) applicationContext.getBean("person");
		System.out.println(person);
		
	}
}
