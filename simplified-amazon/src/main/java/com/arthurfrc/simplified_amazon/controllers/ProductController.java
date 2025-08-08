package com.arthurfrc.simplified_amazon.controllers;

import com.arthurfrc.simplified_amazon.models.AddProductDTO;
import com.arthurfrc.simplified_amazon.models.Product;
import com.arthurfrc.simplified_amazon.repositories.ProductRepository;
import com.arthurfrc.simplified_amazon.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {


    private final ProductService service;

    @Autowired
    public ProductController(ProductService service) {

        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody @Valid AddProductDTO body) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.addProduct(body));
    }
}
