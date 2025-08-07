package com.microservice.order.controller;

import com.microservice.order.model.Order;
import com.microservice.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<String> saveOrder(Order order) {
        return orderService.saveOrder(order);
    }

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        return  orderService.getAllOrders();
    }
}
