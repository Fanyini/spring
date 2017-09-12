package com.atguigu.spring.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("bookShopService")
public class BookShopServiceImpl implements BookShopService {

	@Autowired
	private BookShopDAO bookShopDAO;
	
	// 添加事务注解
	// 1、使用propagation , 指定事务的传播行为，即当前的事务方法被另外一个事务方法调用时
	// 如何使用事务，默认取值为REQUIRED，即使用调用方法的事务
	// REQUIRES_NEW 事务自己的事务，调用的事务方法的事务被挂起
	// 2、使用isolation 指定事务的隔离级别，最常用的取值为READ_COMMITTED
	// 3、默认情况下 Spring 的声明式事务对所有的运行时异常进行回滚，也可以通过对应的属性进行设置，通常情况下取默认值即可
	// @Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.READ_COMMITTED,noRollbackFor={UserCountException.class})
	// 4、使用readonly 指定事务是否为只读事务，表示这个事务只读取数据但是不更新数据，这样可以帮助数据库引擎优化事务
	// 5、使用timeOut 指定强制回滚之前事务可以占用的时间
	@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.READ_COMMITTED, readOnly=false)
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
