package com.atguigu.beans.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atguigu.beans.annotation.controller.UserController;

public class Main {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("beans-annotation.xml");
		
//		TestObject testObject = (TestObject) context.getBean("testObject");
//		System.out.println(testObject);
		
		UserController userController = (UserController) context.getBean("userController");
		System.out.println(userController);
		userController.execute();
//		
//		UserService userService = (UserService) context.getBean("userService");
//		System.out.println(userService);
//		
//		UserRepository userRepository = (UserRepository) context.getBean("userRepository");
//		System.out.println(userRepository);
	}

}
