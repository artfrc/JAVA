package com.microservice.order.repository;

import com.microservice.order.model.OrderedItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrdereItemRepository extends JpaRepository<OrderedItem, UUID> {
}
