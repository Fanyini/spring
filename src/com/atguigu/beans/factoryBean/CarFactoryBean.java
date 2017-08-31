package com.atguigu.beans.factoryBean;

import org.springframework.beans.factory.FactoryBean;

/**
 * 自定义的 FactoryBean 需要实现FactoryBean 接口
 */
public class CarFactoryBean implements FactoryBean<Car> {

	private String brand;

	public void setBrand(String brand) {
		this.brand = brand;
	}

	// 返回bean对象
	public Car getObject() throws Exception {
		return new Car(brand, 500000);
	}

	// 返回的bean的类型
	public Class<?> getObjectType() {
		return Car.class;
	}

	// 是否为单实例
	@Override
	public boolean isSingleton() {
		return true;
	}

}
