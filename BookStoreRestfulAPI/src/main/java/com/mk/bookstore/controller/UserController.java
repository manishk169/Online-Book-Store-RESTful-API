package com.mk.bookstore.controller;

import org.springframework.web.bind.annotation.RestController;

import com.mk.bookstore.entities.User;
import com.mk.bookstore.service.impl.UserServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/api/users")
public class UserController {

//	baseUrl = "http://localhost:8080/api/users"
//  User Module : Register a User (POST):  /registers
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@PostMapping("/register")
	public User register(@RequestBody User user) {
		
		return userServiceImpl.registerUser(user);
	}
	
}
