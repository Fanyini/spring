package com.atguigu.beans.annotation.sercive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.atguigu.beans.annotation.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	// @Qualifier("userRepositoryImpl") // ָ��װ��bean������
	private UserRepository userRepository;

	// @Autowired ���Լ���setter������ 
	// public void setUserRepository(UserRepository userRepository) {
	// this.userRepository = userRepository;
	// }
	
	public void setUserRepository(@Qualifier("userRepositoryImpl") UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	public void add() {
		System.out.println("UserService add ����");
		userRepository.save();
	}
}
