package com.petland.petland_api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cadastro {
   
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;

   @Column(length = 50, nullable = false)
   private String nome;

   @Embedded
   private Perfil perfil;

   @Embedded
   private Endereco endereco;

   public Cadastro(String nome, Perfil perfil, Endereco endereco) {
      this.nome = nome;
      this.perfil = perfil;
      this.endereco = endereco;
   }

   public Cadastro() {
   }
   
   public Perfil getPerfil() {
      return perfil;
   }
   public void setPerfil(Perfil perfil) {
      this.perfil = perfil;
   }
   public Endereco getEndereco() {
      return endereco;
   }
   public void setEndereco(Endereco endereco) {
      this.endereco = endereco;
   }
   public String getNome() {
      return nome;
   }
   public void setNome(String nome) {
      this.nome = nome;
   }

}
