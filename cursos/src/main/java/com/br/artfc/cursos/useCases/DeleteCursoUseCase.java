package com.br.artfc.cursos.useCases;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.artfc.cursos.repositories.CursoRepository;

@Service
public class DeleteCursoUseCase {
   
   @Autowired
   private CursoRepository cursoRepository;

   public void execute(UUID id) {
      this.cursoRepository.deleteById(id);
   }

}
