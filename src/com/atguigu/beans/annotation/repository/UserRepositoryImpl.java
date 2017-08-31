package com.atguigu.beans.annotation.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.atguigu.beans.annotation.TestObject;

// @Repository("userRepository") Ä¬ÈÏÎª value Öµ
@Repository
public class UserRepositoryImpl implements UserRepository {

	@Autowired
	private TestObject testObject;

	@Override
	public void save() {
		System.out.println("UserRepositoryImpl save ¡­¡­");
		System.out.println(testObject);
	}

}
