package com.atguigu.beans.collection;

import java.util.List;

import com.atguigu.beans.Car;

public class Person {

	private String name;
	private int age;
	private List<Car> car;

	public Person() {
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Car> getCar() {
		return car;
	}

	public void setCar(List<Car> car) {
		this.car = car;
	}

	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", car=" + car + "]";
	}

}
