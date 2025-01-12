package com.br.artfc.cursos.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.artfc.cursos.exceptions.CursoFoundException;
import com.br.artfc.cursos.models.CursoEntity;
import com.br.artfc.cursos.repositories.CursoRepository;

@Service
public class CreateCursoUseCase {

   @Autowired
   private CursoRepository cursoRepository;

   public CursoEntity execute(CursoEntity cursoEntity) {

      CursoEntity curso = new CursoEntity(cursoEntity.getName(), cursoEntity.getCategory());
      
      this.cursoRepository.findByName(curso.getName()).ifPresent((cursoFound) -> {
         throw new CursoFoundException("Curso already exists");
      });

      return this.cursoRepository.save(curso); 
   }
   
}
