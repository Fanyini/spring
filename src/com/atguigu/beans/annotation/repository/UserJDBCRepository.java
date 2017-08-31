package com.atguigu.beans.annotation.repository;

public class UserJDBCRepository implements UserRepository{

	@Override
	public void save() {
		System.out.println("UserJDBCRepository save бнбн");
	}

}
