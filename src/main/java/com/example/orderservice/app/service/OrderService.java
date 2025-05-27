package com.example.orderservice.app.service;

import com.example.orderservice.dto.OrderRequest;
import com.example.orderservice.dto.OrderResponse;
import com.example.orderservice.model.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface OrderService {
    List<Order> getHighValueOrders(Double minAmount);

    OrderResponse saveOrder(OrderRequest request);


    Page<Order> getAllOrders(Pageable pageable);
}
