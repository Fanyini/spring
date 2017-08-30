package com.atguigu.beans.cycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("postProcessAfterInitialization" + bean + ", " + beanName);
		// 可以对传入的bean进行处理，甚至是创建一个新的bean来返回
		// Car car = new Car();
		// car.setName("Fute");
		
		// 该方法会处理所有的bean， 所以此处可以进行判断
		
		return bean;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("postProcessBeforeInitialization" + bean + ", " + beanName);
		return bean;
	}

}
