package com.atguigu.beans.spel;

public class Person {

	private String name;
	private Car car;

	// ����address bean ��city����
	private String city;

	// ����car ��price ȷ�� info�� car �� price >= 300000 : ����
	// ����Ϊ �� ����
	private String info;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", car=" + car + ", city=" + city + ", info=" + info + "]";
	}

}