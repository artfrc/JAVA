   package com.petland.petland_api.model;

   import jakarta.persistence.Column;
   import jakarta.persistence.Embeddable;

   @Embeddable
   public class Endereco {
      
      @Column(length = 50)
      private String logradouro;

      @Column(length = 6)
      private String numero;

      public Endereco(String logradouro, String numero) {
         this.logradouro = logradouro;
         this.numero = numero;
      }

      public Endereco() {
      }
      
      public String getLogradouro() {
         return logradouro;
      }
      public void setLogradouro(String logradouro) {
         this.logradouro = logradouro;
      }
      public String getNumero() {
         return numero;
      }
      public void setNumero(String numero) {
         this.numero = numero;
      }

      
   }
