package com.arthurfrc.simplified_amazon.services;

import com.arthurfrc.simplified_amazon.models.AddProductDTO;
import com.arthurfrc.simplified_amazon.models.Product;
import com.arthurfrc.simplified_amazon.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository repository;

    @Autowired
    public ProductService(ProductRepository repo) {
        this.repository = repo;
    }

    public Product addProduct(AddProductDTO productDto) {
        Product product = new Product(productDto);

        return repository.save(product);
    }
}
