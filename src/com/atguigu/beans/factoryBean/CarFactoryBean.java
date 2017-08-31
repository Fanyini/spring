package com.atguigu.beans.factoryBean;

import org.springframework.beans.factory.FactoryBean;

/**
 * �Զ���� FactoryBean ��Ҫʵ��FactoryBean �ӿ�
 */
public class CarFactoryBean implements FactoryBean<Car> {

	private String brand;

	public void setBrand(String brand) {
		this.brand = brand;
	}

	// ����bean����
	public Car getObject() throws Exception {
		return new Car(brand, 500000);
	}

	// ���ص�bean������
	public Class<?> getObjectType() {
		return Car.class;
	}

	// �Ƿ�Ϊ��ʵ��
	@Override
	public boolean isSingleton() {
		return true;
	}

}
