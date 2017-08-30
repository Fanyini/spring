package com.atguigu.beans.factory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("beans-factory.xml");
		
		Car car = (Car) context.getBean("carOne");
		System.out.println(car);
	}

}
