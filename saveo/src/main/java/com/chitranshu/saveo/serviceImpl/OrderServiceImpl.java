package com.chitranshu.saveo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chitranshu.saveo.model.Order;
import com.chitranshu.saveo.repository.MedicineRepository;
import com.chitranshu.saveo.repository.OrderRepository;
import com.chitranshu.saveo.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	MedicineRepository medicineRepository;
	
	@Autowired
	OrderRepository orderRepository;

	//Could Not implement full order logic due to time constraint.
	@Override
	public Long placeOrder(List<Order> orders) {

		Long uniqeId = 0l;
		for(Order order :orders) {
			Order od = orderRepository.saveAndFlush(order);
			uniqeId += od.getOrderId();
		}
		return uniqeId;
	}

}
