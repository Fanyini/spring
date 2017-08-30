package com.atguigu.beans.scope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atguigu.beans.autoWrite.Car;

public class Main {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans-scope.xml");

		// 配置文件中bean的 scope属性默认值为 singleton，即单例（在配置文件声明周期中只初始化一次）
		// 若scope的值为 prototype 表示为原型，在加载配置文件的时候不会自动创建bean，在使用一次就创建一次
		Car car = (Car) applicationContext.getBean("car");
		Car car2 = (Car) applicationContext.getBean("car");
		System.out.println(car == car2);
	}
}
