package br.com.artfc.gestao_projeto_vagas.modules.candidate;

import java.util.UUID;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class CandidateEntity {
   
   private UUID id;
   private String name;

   @Pattern(regexp = "^[a-z0-9_-]{3,15}$", message = "Username only lowercase letters, numbers, hyphens and underscores are allowed")
   private String username;

   @Email(message = "Email should be valid")
   private String email;

   @Length(min = 6, max = 36, message = "Password should be between 6 and 36 characters")
   private String password;
   private String description;
   private String curriculum;
}
