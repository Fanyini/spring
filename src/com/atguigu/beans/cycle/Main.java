package com.atguigu.beans.cycle;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {

		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean-cycle.xml");
		Car car = (Car) applicationContext.getBean("car");
		System.out.println(car);
		
		// �ر�ioc ����
		applicationContext.close();
		
	}
}
