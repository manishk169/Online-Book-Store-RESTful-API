package com.mk.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mk.bookstore.entities.Order;
import com.mk.bookstore.service.impl.OrderServiceImpl;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

//	baseUrl = "http://localhost:8080/api/orders"
//Order Module: 1. Creating an order           (POST) :            /place
//	            2. Getting an order by user ID  (GET) :            /user/{userId}
	
	@Autowired
	private OrderServiceImpl orderServiceImpl;
	
	  @PostMapping("/place")
	    public Order placeOrder(@RequestBody Order order) {
	        // Only allow registered users to place orders
	        return orderServiceImpl.placeOrder(order);
	    }

	    @GetMapping("/user/{userId}")
	    public List<Order> getOrdersByUserId(@PathVariable Long userId) {
	        return orderServiceImpl.getOrdersByUserId(userId);
	    }
	
}
