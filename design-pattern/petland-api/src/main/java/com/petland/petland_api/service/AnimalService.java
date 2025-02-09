package com.petland.petland_api.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petland.petland_api.dto.AnimalRequestDTO;
import com.petland.petland_api.dto.AnimalResponseDTO;
import com.petland.petland_api.dto.AnimalUpdateDTO;
import com.petland.petland_api.model.Animal;
import com.petland.petland_api.repositories.AnimalRepository;


@Service
public class AnimalService {
   
   @Autowired
   private AnimalRepository repository;

   public List<AnimalResponseDTO> getAnimals() {
      return repository.findAll().stream()
            .map(animal -> new AnimalResponseDTO(
                animal.getId(),
                animal.getNome(),
                animal.getAniversario().toString(),
                animal.getEspecie().toString()
            ))
            .collect(Collectors.toList());
   }

   public AnimalResponseDTO getAnimalById(Integer id) {
      return repository.findById(id)
            .map(animal -> new AnimalResponseDTO(
                animal.getId(),
                animal.getNome(),
                animal.getAniversario().toString(),
                animal.getEspecie().toString()
            ))
            .orElseThrow(() -> new RuntimeException("Animal not found"));
   }

   public void createAnimal(AnimalRequestDTO dto) {
      Animal animal = new Animal(
         dto.nome(),
         dto.aniversario(),
         dto.especie()
      );
      repository.save(animal);
   }

   public void updateAnimal(Integer id, AnimalUpdateDTO dto) {
      Animal animal = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Animal not found"));
      dto.nome().ifPresent(animal::setNome);
      dto.aniversario().ifPresent(animal::setAniversario);
      dto.especie().ifPresent(animal::setEspecie);

      repository.save(animal);
   }

   public void deleteAnimal(Integer id) {
      repository.deleteById(id);
   }
}
