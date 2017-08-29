package com.atguigu.beans;

public class HelloWorld {

	private String name;

	public HelloWorld() {
	}

	public void setName(String name) {
		this.name = name;
	}

	public void hello() {
		System.out.println("hello £º " + name);
	}
}
