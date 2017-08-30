package com.atguigu.beans.scope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atguigu.beans.autoWrite.Car;

public class Main {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans-scope.xml");

		// �����ļ���bean�� scope����Ĭ��ֵΪ singleton�����������������ļ�����������ֻ��ʼ��һ�Σ�
		// ��scope��ֵΪ prototype ��ʾΪԭ�ͣ��ڼ��������ļ���ʱ�򲻻��Զ�����bean����ʹ��һ�ξʹ���һ��
		Car car = (Car) applicationContext.getBean("car");
		Car car2 = (Car) applicationContext.getBean("car");
		System.out.println(car == car2);
	}
}
