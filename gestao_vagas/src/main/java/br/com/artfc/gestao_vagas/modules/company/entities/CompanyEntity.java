package br.com.artfc.gestao_vagas.modules.company.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity(name = "company")
public class CompanyEntity {

   @Id
   @GeneratedValue(strategy = GenerationType.UUID)
   private UUID id;

   @NotBlank
   @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "Username should contain only letters and numbers")
   private String username;

   @Length(min = 6, max = 64, message = "Password should be between 6 and 32 characters")
   private String password;

   @Email(message = "Email should be valid")
   private String email;
   private String website;
   private String description;
   private String name;

   @CreationTimestamp
   private LocalDateTime createdAt;
   
   public LocalDateTime getCreatedAt() {
      return createdAt;
   }
   public void setCreatedAt(LocalDateTime createdAt) {
      this.createdAt = createdAt;
   }
   public UUID getId() {
      return id;
   }
   public void setId(UUID id) {
      this.id = id;
   }
   public String getUsername() {
      return username;
   }
   public void setUsername(String username) {
      this.username = username;
   }
   public String getPassword() {
      return password;
   }
   public void setPassword(String password) {
      this.password = password;
   }
   public String getEmail() {
      return email;
   }
   public void setEmail(String email) {
      this.email = email;
   }
   public String getWebsite() {
      return website;
   }
   public void setWebsite(String website) {
      this.website = website;
   }
   public String getDescription() {
      return description;
   }
   public void setDescription(String description) {
      this.description = description;
   }
   public String getName() {
      return name;
   }
   public void setName(String name) {
      this.name = name;
   }
   
}
