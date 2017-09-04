package com.atguigu.beans.generic.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans-generic-di.xml");
		
		UserService service = (UserService) context.getBean("userService");
		service.add();
	}
}
