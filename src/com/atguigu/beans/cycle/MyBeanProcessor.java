package com.atguigu.beans.cycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("postProcessAfterInitialization" + bean + ", " + beanName);
		// ���ԶԴ����bean���д��������Ǵ���һ���µ�bean������
		// Car car = new Car();
		// car.setName("Fute");
		
		// �÷����ᴦ�����е�bean�� ���Դ˴����Խ����ж�
		
		return bean;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("postProcessBeforeInitialization" + bean + ", " + beanName);
		return bean;
	}

}
