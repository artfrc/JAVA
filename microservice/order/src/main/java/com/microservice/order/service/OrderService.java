package com.microservice.order.service;

import com.microservice.order.model.Order;
import com.microservice.order.model.OrderedItem;
import com.microservice.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

   private final OrderRepository orderRepository;

   @Autowired
   public OrderService(OrderRepository orderRepository) {
       this.orderRepository = orderRepository;
   }

   public Order saveOrder(Order order) {

       if(order.getItens() != null) {
           for(OrderedItem item : order.getItens()) {
               item.setOrder(order);
           }
       }

       orderRepository.save(order);

       return order;
   }

   public ResponseEntity<List<Order>> getAllOrders() {
       return ResponseEntity.status(HttpStatus.OK).body(orderRepository.findAll());
   }
}
