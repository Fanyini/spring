package com.atguigu.beans.collection;

import java.util.Map;

public class NewPerson {

	private String name;
	private int age;
	private Map<String, Object> carMap;

	public NewPerson() {
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

	public Map<String, Object> getCarMap() {
		return carMap;
	}

	public void setCarMap(Map<String, Object> carMap) {
		this.carMap = carMap;
	}

	@Override
	public String toString() {
		return "Person2 [name=" + name + ", age=" + age + ", carMap=" + carMap + "]";
	}

}
