package com.petland.petland_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petland.petland_api.model.ProdutoServico;

public interface ProdutoServicoRepository extends JpaRepository<ProdutoServico, Integer>{
   
}
