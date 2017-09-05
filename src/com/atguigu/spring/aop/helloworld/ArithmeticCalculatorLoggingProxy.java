package com.atguigu.spring.aop.helloworld;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.cglib.proxy.Proxy;

/**
 * 使用动态代理
 * 
 * @author dell
 *
 */
public class ArithmeticCalculatorLoggingProxy {

	// 需要代理的对象
	private ArithmeticCalculator target;

	public ArithmeticCalculatorLoggingProxy(ArithmeticCalculator target) {
		this.target = target;
	}
	
	public ArithmeticCalculator getLoggingProxy() {
		ArithmeticCalculator proxy = null;

		// 代理对象由那一个类加载器加载的
		ClassLoader loader = target.getClass().getClassLoader();
		// 代理类使用哪些接口，即代理类是使用哪些类型的
		// 代理对象的类型，即其中有哪些方法
		Class[] interfaces = new Class[] { ArithmeticCalculator.class };
		// 当调用代理对象其中的方法时，执行该代码
		InvocationHandler h = new InvocationHandler() {
			/**
			 * 参数：
			 * proxy : 正在返回的那个代理对象，一般情况下invoke 方法中不使用该代理对象！
			 * method : 正在被调用的方法
			 * args : 调用方法时传入的参数
			 */
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				String methodName = method.getName(); // 获取当前的方法名
				System.out.println("The method " + methodName +" begin with " + Arrays.asList(args));
				// 执行方法
				Object result = null;
				try{
					// 前置通知
					result = method.invoke(target, args);
					// 返回通知（能够返回方法的返回值）
				}catch(Exception e){
					e.printStackTrace();
					// 异常通知，可以访问到方法出现的异常
				}
				// 后置通知，因为方法可能会出现异常，所以访问不到方法的返回值
				
				// 打印日志
				System.out.println("The method " + methodName +" ends with " + result);
				return result;
			}
		};
		proxy = (ArithmeticCalculator) Proxy.newProxyInstance(loader, interfaces, h);
		return proxy;
	}
}
