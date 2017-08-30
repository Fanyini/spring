package com.atguigu.beans.factory;

import java.util.HashMap;
import java.util.Map;
/**
 * 实例工厂方法： 
 */
public class InstanceCarFactory {

	private Map<String, Car> cars = null;
	
	public InstanceCarFactory() {
		cars = new HashMap<>();
		cars.put("audi", new Car ("audi", 3));
		cars.put("ford", new Car ("ford", 4));
	}
	
	public Car getCar(String brand){
		return cars.get(brand);
	}
}
