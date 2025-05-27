package com.example.orderservice.controller;

import com.example.orderservice.app.service.OrderService;
import com.example.orderservice.dto.OrderRequest;
import com.example.orderservice.model.Order;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public Page<Order> getAllOrders(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        return orderService.getAllOrders(pageable);
    }


    @GetMapping("/high-value")
    public List<Order> getHighValueOrders(@RequestParam Double minAmount) {
        return orderService.getHighValueOrders(minAmount);
    }

    @PostMapping
    public ResponseEntity<?> createOrder(@Valid @RequestBody OrderRequest request) {
        Order order = new Order();
        order.setCustomerName(request.getCustomerName());
        order.setTotalAmount(request.getTotalAmount());

        Order savedOrder = orderService.saveOrder(order);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedOrder);
    }
}

