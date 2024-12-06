package com.mk.bookstore.service;

import java.util.List;

import com.mk.bookstore.entities.Order;

public interface OrderService{
	
	public Order placeOrder(Order order);
	
	public List<Order> getOrdersByUserId(Long userId);
	
}
