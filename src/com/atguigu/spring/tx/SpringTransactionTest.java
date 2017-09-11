package com.atguigu.spring.tx;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTransactionTest {

	private ApplicationContext context = null;
	private BookShopDAO bookShopDAO = null;
	private BookShopService bookShopService;
	{
		context = new ClassPathXmlApplicationContext("jdbc_applicationContext.xml");
		bookShopDAO = context.getBean(BookShopDAO.class);
		bookShopService = context.getBean(BookShopService.class);
	}
	
	@Test
	public void testBookShopFindPriceByIsbm(){
		System.out.println(bookShopDAO.findBookPriceByIsbn("1001"));
	}
	
	// 更新书的库存
	@Test
	public void testUpdateBookStock(){
		bookShopDAO.updateBookStock("1001");
	}
	
	// 更细用户的账户
	@Test
	public void testShopDaoUpdateUserCount(){
		bookShopDAO.updateUserAccount("aaa", 200);
	}
	
	
	@Test
	public void testBookShopService(){
		bookShopService.purchase("aaa", "1001");
	}
	
}
