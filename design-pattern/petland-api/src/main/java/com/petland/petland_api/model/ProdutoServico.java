package com.petland.petland_api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ProdutoServico {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;

   @Column(nullable = false, length = 50)
   private String nome;
   
   public ProdutoServico(String nome, Double valor, Boolean servico) {
      this.nome = nome;
      this.valor = valor;
      this.servico = servico;
   }

   public ProdutoServico() {
   }

   public String getNome() {
      return nome;
   }

   public void setNome(String nome) {
      this.nome = nome;
   }

   private Double valor;

   private Boolean servico;


   public Double getValor() {
      return valor;
   }

   public void setValor(Double valor) {
      this.valor = valor;
   }

   public Boolean getServico() {
      return servico;
   }

   public void setServico(Boolean servico) {
      this.servico = servico;
   }
   
}
