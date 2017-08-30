package com.atguigu.beans.relaction;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atguigu.beans.autoWrite.Person;
import com.atguigu.beans.autoWrite.Address;

public class Main {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans-relation.xml");

		Address	address = (Address) applicationContext.getBean("addresst");
		System.out.println(address);
		
		
		Person person = (Person) applicationContext.getBean("person");
		System.out.println(person);
	}
}
