package com.atguigu.beans.factoryBean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans-factoryBean.xml");
		
		Car car = (Car) context.getBean("carFactoryBean");
		System.out.println(car);
	}

}
