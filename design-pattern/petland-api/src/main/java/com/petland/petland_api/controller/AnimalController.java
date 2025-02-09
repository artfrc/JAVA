package com.petland.petland_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petland.petland_api.model.Animal;
import com.petland.petland_api.repositories.AnimalRepository;

@RestController
public class AnimalController {

   @Autowired
   private AnimalRepository repository;

   @GetMapping("/animals")
   public List<Animal> getAnimals() {
      return repository.findAll();
   }
   
}
