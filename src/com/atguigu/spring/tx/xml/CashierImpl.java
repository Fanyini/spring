package com.atguigu.spring.tx.xml;

import java.util.List;

import com.atguigu.spring.tx.xml.service.BookShopService;
import com.atguigu.spring.tx.xml.service.Cashier;

public class CashierImpl implements Cashier {

	private BookShopService bookShopService;
	
	public void setBookShopService(BookShopService bookShopService) {
		this.bookShopService = bookShopService;
	}
	
	public void checkout(String username, List<String> isbm) {
		for(String isb : isbm){
			bookShopService.purchase(username, isb);
		}
	}

}
