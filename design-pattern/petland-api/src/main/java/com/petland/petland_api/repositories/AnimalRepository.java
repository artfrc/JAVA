package com.petland.petland_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petland.petland_api.model.Animal;

public interface AnimalRepository extends JpaRepository<Animal, Integer>{
   
}
