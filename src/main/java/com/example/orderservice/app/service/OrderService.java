package com.example.orderservice.app.service;

import com.example.orderservice.model.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface OrderService {
    List<Order> getHighValueOrders(Double minAmount);

    Order saveOrder(Order order);

    Page<Order> getAllOrders(Pageable pageable);
}
