package com.br.artfc.cursos.controllers;

import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.artfc.cursos.dto.CursoRequestUpdateDTO;
import com.br.artfc.cursos.models.CursoEntity;
import com.br.artfc.cursos.useCases.CreateCursoUseCase;
import com.br.artfc.cursos.useCases.DeleteCursoUseCase;
import com.br.artfc.cursos.useCases.ListCursoUseCase;
import com.br.artfc.cursos.useCases.UpdateCursoUseCase;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/curso")
public class CursoController {

   @Autowired
   private CreateCursoUseCase createCursoUseCase;

   @Autowired
   private ListCursoUseCase listCursoUseCase;

   @Autowired
   private DeleteCursoUseCase deleteCursoUseCase;

   @Autowired
   private UpdateCursoUseCase updateCursoUseCase;

   @PostMapping("/create")
   public ResponseEntity<Object> create(@Valid @RequestBody CursoEntity curso) {

      try {
         var result = this.createCursoUseCase.execute(curso);

         return ResponseEntity.ok().body(result);
      }catch(Exception e) {
         return ResponseEntity.badRequest().body(e.getMessage());
      }
   }

   @GetMapping("/list")
   public ResponseEntity<Map<String, Object>> list() {
      return ResponseEntity.ok().body(this.listCursoUseCase.execute());
   }

   @DeleteMapping("/delete/{id}")
   public ResponseEntity<Object> delete(@PathVariable("id") UUID id) {
      try{
         this.deleteCursoUseCase.execute(id);
         return ResponseEntity.ok().build();    
      }catch(IllegalArgumentException e) {
         return ResponseEntity.badRequest().body(e.getMessage());
      }
   }

   @PatchMapping("/update/{id}")
   public ResponseEntity<Object> update(@PathVariable("id") UUID id, @RequestBody CursoRequestUpdateDTO curso) {
      try {
         var result = this.updateCursoUseCase.execute(id,curso);

         return ResponseEntity.ok().body(result);
      }catch(Exception e) {
         return ResponseEntity.badRequest().body(e.getMessage());
      }     
   }
   
}