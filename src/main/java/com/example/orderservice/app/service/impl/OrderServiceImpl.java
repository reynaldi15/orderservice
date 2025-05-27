package com.example.orderservice.app.service.impl;

import com.example.orderservice.app.service.OrderService;
import com.example.orderservice.model.Order;
import com.example.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository repository;

    @Override
    public Page<Order> getAllOrders(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public List<Order> getHighValueOrders(Double minAmount) {
        return repository.findHighValueOrders(minAmount)
                .stream()
                .filter(order -> order.getCustomerName() != null && !order.getCustomerName().isBlank())
                .collect(Collectors.toList());
    }

    @Override
    public Order saveOrder(Order order) {
        return repository.save(order);
    }
}