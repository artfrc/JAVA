package com.petland.petland_api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Cadastro {
   
   @Id
   private Integer id;
   private String nome;
   // private Perfil perfil;
   // private Endereco endereco;

}
