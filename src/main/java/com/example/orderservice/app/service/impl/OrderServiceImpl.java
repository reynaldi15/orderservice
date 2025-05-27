package com.example.orderservice.app.service.impl;

import com.example.orderservice.app.service.OrderService;
import com.example.orderservice.dto.OrderRequest;
import com.example.orderservice.dto.OrderResponse;
import com.example.orderservice.model.Order;
import com.example.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
    public OrderResponse saveOrder(OrderRequest request) {
        Order order = new Order();
        order.setCustomerName(request.getCustomerName());
        order.setTotalAmount(request.getTotalAmount());
        order.setCreatedAt(LocalDateTime.now());

        Order savedOrder = repository.save(order);

        // Mapping ke DTO Response
        OrderResponse response = new OrderResponse();
        response.setId(savedOrder.getId());
        response.setCustomerName(savedOrder.getCustomerName());
        response.setTotalAmount(savedOrder.getTotalAmount());
        response.setCreatedAt(savedOrder.getCreatedAt());

        return response;
    }
}