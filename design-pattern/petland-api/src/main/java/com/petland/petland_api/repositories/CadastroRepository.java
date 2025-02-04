package com.petland.petland_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petland.petland_api.model.Cadastro;

public interface CadastroRepository extends JpaRepository<Cadastro, Integer> {
   
}
