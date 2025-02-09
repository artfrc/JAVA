package com.petland.petland_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petland.petland_api.model.ProdutoServico;
import com.petland.petland_api.repositories.ProdutoServicoRepository;

@RestController
@RequestMapping("/products")
public class ProdutoServicoController {

   @Autowired
   private ProdutoServicoRepository repository;

   @GetMapping()
   public List<ProdutoServico> getProducts() {
      return repository.findAll();
   }

   @PostMapping()
   public void addProduct(@RequestBody ProdutoServico product) {
      repository.save(product);
   }

   @PutMapping("/{id}")
   public void updateProduct(@PathVariable ("id") Integer id,
                             @RequestBody ProdutoServico product) {
      repository.save(product);
   }

   @DeleteMapping("/{id}")
   public void deleteProduct(@PathVariable ("id") Integer id) {
      repository.deleteById(id);
   }
   
}
