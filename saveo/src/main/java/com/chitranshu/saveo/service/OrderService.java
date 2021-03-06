package com.chitranshu.saveo.service;

import java.util.List;

import com.chitranshu.saveo.model.Order;

public interface OrderService {
	Long placeOrder(List<Order> orders);
}
