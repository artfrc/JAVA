package com.petland.petland_api.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class Perfil {

   private Boolean cliente;
   private Boolean fornecedor;
   private Boolean prestador;

   public Perfil(Boolean cliente, Boolean fornecedor, Boolean prestador) {
      this.cliente = cliente;
      this.fornecedor = fornecedor;
      this.prestador = prestador;
   }

   public Perfil() {
   }
   
   public Boolean getCliente() {
      return cliente;
   }
   public void setCliente(Boolean cliente) {
      this.cliente = cliente;
   }
   public Boolean getFornecedor() {
      return fornecedor;
   }
   public void setFornecedor(Boolean fornecedor) {
      this.fornecedor = fornecedor;
   }
   public Boolean getPrestador() {
      return prestador;
   }
   public void setPrestador(Boolean prestador) {
      this.prestador = prestador;
   }
   
   
}
