package com.atguigu.spring.tx;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("cashier")
public class CashierImpl implements Cashier {

	@Autowired
	private BookShopService bookShopService;
	
	public void checkout(String username, List<String> isbm) {
		for(String isb : isbm){
			bookShopService.purchase(username, isb);
		}
	}

}
