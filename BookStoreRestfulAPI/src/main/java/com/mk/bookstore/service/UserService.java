package com.mk.bookstore.service;

import com.mk.bookstore.entities.User;

public interface UserService {
	public User registerUser(User user);
	
	public User findById(Long id);
}
