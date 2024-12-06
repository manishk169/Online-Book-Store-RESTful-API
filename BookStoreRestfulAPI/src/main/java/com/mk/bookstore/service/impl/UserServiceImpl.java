package com.mk.bookstore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mk.bookstore.entities.User;
import com.mk.bookstore.repository.UserRepository;
import com.mk.bookstore.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User registerUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
	}
	
	
}
