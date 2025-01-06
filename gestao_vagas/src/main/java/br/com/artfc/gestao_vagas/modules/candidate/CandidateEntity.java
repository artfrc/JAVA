package br.com.artfc.gestao_vagas.modules.candidate;

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

@Entity(name = "candidate")
public class CandidateEntity {
   
   @Id
   @GeneratedValue(strategy = GenerationType.UUID)
   private UUID id;

   private String name;

   @NotBlank(message = "Username is required")
   @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "Username should contain only letters and numbers")
   private String username;

   @Email(message = "Email should be valid")
   @NotBlank(message = "Email is required")
   private String email;

   @Length(min = 6, max = 64, message = "Password should be between 6 and 32 characters")
   private String password;
   private String description;
   private String curriculum;

   @CreationTimestamp
   private LocalDateTime createdAt;

   public CandidateEntity(UUID id, String name, String username, String email, String password, String description, String curriculum) {
      this.id = id;
      this.name = name;
      this.username = username;
      this.email = email;
      this.password = password;
      this.description = description;
      this.curriculum = curriculum;
   }

   public CandidateEntity() {
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

   public String getUsername() {
      return username;
   }

   public void setUsername(String username) {
      this.username = username;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public String getDescription() {
      return description;
   }

   public void setDescription(String description) {
      this.description = description;
   }

   public String getCurriculum() {
      return curriculum;
   }

   public void setCurriculum(String curriculum) {
      this.curriculum = curriculum;
   }

}
