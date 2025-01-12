package com.br.artfc.cursos.useCases;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.artfc.cursos.dto.CursoRequestUpdateDTO;
import com.br.artfc.cursos.exceptions.CursoFoundException;
import com.br.artfc.cursos.models.CursoEntity;
import com.br.artfc.cursos.repositories.CursoRepository;

@Service
public class UpdateCursoUseCase {

   @Autowired
   private CursoRepository cursoRepository;
   
   public Optional<CursoEntity> execute(UUID id, CursoRequestUpdateDTO cursoRequestUpdate) {
      var curso = this.cursoRepository.findById(id);

      if(curso.isEmpty()) {
         throw new CursoFoundException("Course not found");
      }

      if(cursoRequestUpdate.name() != null) {
         curso.get().setName(cursoRequestUpdate.name());
      }

      if(cursoRequestUpdate.category() != null) {
         curso.get().setCategory(cursoRequestUpdate.category());
      }
      
      if(cursoRequestUpdate.active() != null) {
         curso.get().setActive(cursoRequestUpdate.active());
      }

      this.cursoRepository.save(curso.get());

      return curso;


   }
}
