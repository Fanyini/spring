package com.atguigu.beans.generic.di;

import org.springframework.beans.factory.annotation.Autowired;

public class BaseService<T> {
	
	// 在这个上边加上注解能被子类继承
	@Autowired
	protected BaseRepository<T> repository;
	
	public void add(){
		System.out.println("add ... ");
		System.out.println(repository);
	}
}
