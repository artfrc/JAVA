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

import com.petland.petland_api.dto.AnimalRequestDTO;
import com.petland.petland_api.dto.AnimalResponseDTO;
import com.petland.petland_api.dto.AnimalUpdateDTO;
import com.petland.petland_api.service.AnimalService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/animals")
public class AnimalController {

   @Autowired
   private AnimalService service;

   @GetMapping
   public List<AnimalResponseDTO> getAnimals() {
      return service.getAnimals();
   }

   @GetMapping("/{id}")
   public AnimalResponseDTO getAnimalById(@PathVariable("id") Integer id) {
      return service.getAnimalById(id);
   }

   @PostMapping
   public void createAnimal(@RequestBody @Valid AnimalRequestDTO dto) {
      service.createAnimal(dto);
   }

   @PutMapping("/{id}")
   public void updateAnimal(@RequestBody @Valid AnimalUpdateDTO dto, @PathVariable("id") Integer id) {
      service.updateAnimal(id, dto);
   }

   @DeleteMapping("/{id}")
   public void deleteAnimal(@PathVariable("id") Integer id) {
      service.deleteAnimal(id);
   }
   
}
