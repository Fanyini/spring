package com.atguigu.beans.annotation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.atguigu.beans.annotation.sercive.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	public void execute() {
		System.out.println("UserController execute бнбн");
		userService.add();
	}
}
