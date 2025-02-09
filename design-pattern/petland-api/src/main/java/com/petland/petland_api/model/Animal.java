package com.petland.petland_api.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Animal {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;

   @Column(nullable = false)
   private String nome;

   @Column(length = 50)
   private LocalDate aniversario;

   @Enumerated(EnumType.STRING)
   private AnimalEspecie especie;
   

   public Animal() {
   }

   public Animal(String nome, LocalDate aniversario, AnimalEspecie especie) {
      this.nome = nome;
      this.aniversario = aniversario;
      this.especie = especie;
   }


   public Integer getId() {
      return id;
   }

   public String getNome() {
      return nome;
   }

   public void setNome(String nome) {
      this.nome = nome;
   }

   public LocalDate getAniversario() {
      return aniversario;
   }

   public void setAniversario(LocalDate aniversario) {
      this.aniversario = aniversario;
   }

   public AnimalEspecie getEspecie() {
      return especie;
   }

   public void setEspecie(AnimalEspecie especie) {
      this.especie = especie;
   }

   
   
}
