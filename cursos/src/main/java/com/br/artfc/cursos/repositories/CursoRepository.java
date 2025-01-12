package com.br.artfc.cursos.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.artfc.cursos.models.CursoEntity;

@Repository
public interface CursoRepository extends JpaRepository<CursoEntity, UUID> {

   Optional<CursoEntity> findByName(String name);
}
