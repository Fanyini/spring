package com.atguigu.beans.collection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		Person person = (Person) applicationContext.getBean("personCollection");
		System.out.println(person);
		
		NewPerson newPerson = (NewPerson) applicationContext.getBean("newPerson");
		System.out.println(newPerson);
		
		DataSource dataSource = applicationContext.getBean(DataSource.class);
		System.out.println(dataSource);
		
		Person person2 = (Person) applicationContext.getBean("personaa");
		System.err.println(person2);
		
		
		Person personPNameSpace = (Person) applicationContext.getBean("personPNameSpace");
		System.out.println(personPNameSpace);
	}
}
