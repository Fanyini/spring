package com.atguigu.beans.spel;

public class Car {

	private String brand;
	private double price;
	// 轮胎的周长
	private double tyreperimeter;

	public Car() {
		System.out.println("初始化中……");
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getTyreperimeter() {
		return tyreperimeter;
	}

	public void setTyreperimeter(double tyreperimeter) {
		this.tyreperimeter = tyreperimeter;
	}

	@Override
	public String toString() {
		return "Car [brand=" + brand + ", price=" + price + ", tyreperimeter=" + tyreperimeter + "]";
	}

}
