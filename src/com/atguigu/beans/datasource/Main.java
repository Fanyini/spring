package com.atguigu.beans.datasource;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) throws SQLException {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans-datasource.xml");
		
		DataSource dataSource = (DataSource) applicationContext.getBean("pooledDataSource");
		System.out.println(dataSource.getConnection());
	}
}
