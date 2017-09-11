package com.atguigu.spring.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("bookShopService")
public class BookShopServiceImpl implements BookShopService {

	@Autowired
	private BookShopDAO bookShopDAO;
	@Override
	public void purchase(String username, String isbm) {

		// 1、获取书的单价
		int price = bookShopDAO.findBookPriceByIsbn(isbm);

		// 2、更新数据库存
		bookShopDAO.updateBookStock(isbm);
		
		// 3、更新用户的余额
		bookShopDAO.updateUserAccount(username, price);
	}

}
