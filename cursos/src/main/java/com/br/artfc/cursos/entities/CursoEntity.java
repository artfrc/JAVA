package com.br.artfc.cursos.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity(name = "curso")
public class CursoEntity {

   @Id
   @GeneratedValue(strategy = GenerationType.UUID)
   private UUID id;

   @NotBlank(message = "Name is mandatory")
   private String name;

   @NotBlank(message = "Category is mandatory")
   private String category;
   private Boolean active;

   @CreationTimestamp
   private LocalDateTime createdAt;

   @UpdateTimestamp
   private LocalDateTime updatedAt;
   
   public CursoEntity() {}

   public CursoEntity(UUID id, String name, String category) {
      this.id = id;
      this.name = name;
      this.category = category;
      this.active = true;
   }
   
   public UUID getId() {
      return id;
   }
   public void setId(UUID id) {
      this.id = id;
   }
   public String getName() {
      return name;
   }
   public void setName(String name) {
      this.name = name;
   }
   public String getCategory() {
      return category;
   }
   public void setCategory(String category) {
      this.category = category;
   }
   public Boolean getActive() {
      return active;
   }
   public void setActive(Boolean active) {
      this.active = active;
   }
   public LocalDateTime getCreatedAt() {
      return createdAt;
   }
   public void setCreatedAt(LocalDateTime createdAt) {
      this.createdAt = createdAt;
   }
   public LocalDateTime getUpdatedAt() {
      return updatedAt;
   }
   public void setUpdatedAt(LocalDateTime updatedAt) {
      this.updatedAt = updatedAt;
   }
   
   
}
