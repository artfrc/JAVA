package com.arthurfrc.simplified_amazon.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "PRODUCTS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
    private Double price;
    private Integer quantity;

    public Product(AddProductDTO data) {
        this.name = data.name();
        this.price = data.price();
        this.quantity = data.quantity();
    }
}
