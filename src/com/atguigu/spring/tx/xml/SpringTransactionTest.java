package com.atguigu.spring.tx.xml;

import java.util.Arrays;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atguigu.spring.tx.xml.service.BookShopDAO;
import com.atguigu.spring.tx.xml.service.BookShopService;
import com.atguigu.spring.tx.xml.service.Cashier;

public class SpringTransactionTest {

	private ApplicationContext context = null;
	private BookShopDAO bookShopDAO = null;
	private BookShopService bookShopService = null;
	private Cashier cashier = null;
	{
		context = new ClassPathXmlApplicationContext("jdbc_applicationContext_xml.xml");
		bookShopDAO = context.getBean(BookShopDAO.class);
		bookShopService = context.getBean(BookShopService.class);
		cashier = context.getBean(Cashier.class);
	}

	@Test
	public void testBookShopService() {
		bookShopService.purchase("aaa", "1001");
	}

	@Test
	public void testTransactionPropagetion() {
		cashier.checkout("aaa", Arrays.asList("1001", "1002"));
	}

}
