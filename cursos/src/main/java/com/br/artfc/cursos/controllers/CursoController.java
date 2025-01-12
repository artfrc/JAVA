package com.br.artfc.cursos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.artfc.cursos.models.CursoEntity;
import com.br.artfc.cursos.useCases.CreateCursoUseCase;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/curso")
public class CursoController {

   @Autowired
   private CreateCursoUseCase createCursoUseCase;

   @PostMapping("/create")
   public ResponseEntity<Object> create(@Valid @RequestBody CursoEntity curso) {

      try {
         var result = this.createCursoUseCase.execute(curso);

         return ResponseEntity.ok().body(result);
      }catch(Exception e) {
         return ResponseEntity.badRequest().body(e.getMessage());
      }
   }
   
}