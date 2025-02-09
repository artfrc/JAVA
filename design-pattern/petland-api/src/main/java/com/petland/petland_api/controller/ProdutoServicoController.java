package com.petland.petland_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.petland.petland_api.model.ProdutoServico;
import com.petland.petland_api.repositories.ProdutoServicoRepository;

@RestController
public class ProdutoServicoController {

   @Autowired
   private ProdutoServicoRepository repository;

   @GetMapping("/products")
   public List<ProdutoServico> getProducts() {
      return repository.findAll();
   }

   @PostMapping("/products")
   public void addProduct(@RequestBody ProdutoServico product) {
      repository.save(product);
   }
   
}
