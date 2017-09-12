package com.atguigu.spring.tx.xml.service.impl;

import org.springframework.jdbc.core.JdbcTemplate;

import com.atguigu.spring.tx.xml.BookStockException;
import com.atguigu.spring.tx.xml.UserCountException;
import com.atguigu.spring.tx.xml.service.BookShopDAO;

public class BookShopDAOImpl implements BookShopDAO {

	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int findBookPriceByIsbn(String isbm) {
		String sql = "SELECT price from book where isbm=?";
		return jdbcTemplate.queryForObject(sql, Integer.class, isbm);
	}

	@Override
	public void updateBookStock(String isbm) {
		// 查询库存是否足够
		String sql2 = "select stock from book_stock where isbm = ?";
		int count = jdbcTemplate.queryForObject(sql2, Integer.class, isbm);
		if (count == 0) {
			throw new BookStockException("库存不足！！！");
		}
		String sql = "update book_stock SET stock = stock - 1 where isbm = ?";
		jdbcTemplate.update(sql, isbm);
	}

	// 更新账户
	@Override
	public void updateUserAccount(String username, int price) {
		String sql2 = "select balance from account where username = ?";
		int balance = jdbcTemplate.queryForObject(sql2, Integer.class, username);
		if (balance < price) {
			throw new UserCountException("余额不足！！！");
		}
		String sql = "update account set balance = balance - ? where username = ?";
		jdbcTemplate.update(sql, price, username);
	}
}
