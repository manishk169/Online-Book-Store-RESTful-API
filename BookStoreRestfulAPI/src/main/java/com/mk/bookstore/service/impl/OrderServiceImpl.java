package com.mk.bookstore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mk.bookstore.entities.Order;
import com.mk.bookstore.repository.OrderRepository;
import com.mk.bookstore.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@Override
	public Order placeOrder(Order order) {
		if (userServiceImpl.findById(order.getUserId()) == null) {
            throw new RuntimeException("User not found. Only registered users can place orders.");
        }
        return orderRepository.save(order);
	}

	@Override
	public List<Order> getOrdersByUserId(Long userId) {
		
		return orderRepository.findByUserId(userId);
	}

}
