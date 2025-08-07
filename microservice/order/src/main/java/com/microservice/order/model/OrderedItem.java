package com.microservice.order.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "TB_ORDERED_ITEM")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderedItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
    private Integer amount;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
}
