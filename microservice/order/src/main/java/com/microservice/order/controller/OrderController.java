package com.microservice.order.controller;

import com.microservice.order.model.Order;
import com.microservice.order.service.OrderService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final RabbitTemplate rabbitTemplate;
    private final OrderService orderService;

    @Value("${broker.queue.processing.name}")
    private String routingKey;

    @Autowired
    public OrderController(OrderService orderService, RabbitTemplate rabbitTemplate) {
        this.orderService = orderService;
        this.rabbitTemplate = rabbitTemplate;
    }

    @PostMapping
    public ResponseEntity<Order> saveOrder(Order order) {
        Order newOrder =  orderService.saveOrder(order);
        rabbitTemplate.convertAndSend("", routingKey, newOrder.getDescription());

        return ResponseEntity.status(HttpStatus.CREATED).body(newOrder);
    }

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        return  orderService.getAllOrders();
    }
}
