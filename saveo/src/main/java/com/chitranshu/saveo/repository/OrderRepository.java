package com.chitranshu.saveo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chitranshu.saveo.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
