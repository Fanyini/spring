package com.atguigu.spring.tx.xml.service.impl;

import com.atguigu.spring.tx.xml.service.BookShopDAO;
import com.atguigu.spring.tx.xml.service.BookShopService;

public class BookShopServiceImpl implements BookShopService {

	private BookShopDAO bookShopDAO;

	public void setBookShopDAO(BookShopDAO bookShopDAO) {
		this.bookShopDAO = bookShopDAO;
	}

	public void purchase(String username, String isbm) {

		// 1、获取书的单价
		int price = bookShopDAO.findBookPriceByIsbn(isbm);

		// 2、更新数据库存
		bookShopDAO.updateBookStock(isbm);

		// 3、更新用户的余额
		bookShopDAO.updateUserAccount(username, price);
	}

}
