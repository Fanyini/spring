package com.atguigu.beans.annotation.sercive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.atguigu.beans.annotation.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	// @Qualifier("userRepositoryImpl") // 指定装配bean的名字
	private UserRepository userRepository;

	// @Autowired 可以加载setter方法上 
	// public void setUserRepository(UserRepository userRepository) {
	// this.userRepository = userRepository;
	// }
	
	public void setUserRepository(@Qualifier("userRepositoryImpl") UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	public void add() {
		System.out.println("UserService add ……");
		userRepository.save();
	}
}
