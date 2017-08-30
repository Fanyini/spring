package com.atguigu.beans.cycle;

public class Car {
	private String name;

	public Car() {
		System.out.println("Car's constructor¡­¡­");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		System.out.println("set name ¡­¡­");
		this.name = name;
	}

	@Override
	public String toString() {
		return "Car [name=" + name + "]";
	}

	public void init(){
		System.out.println("init¡­¡­");
	}
	
	public void destory(){
		System.out.println("destory¡­¡­");
	}
}
