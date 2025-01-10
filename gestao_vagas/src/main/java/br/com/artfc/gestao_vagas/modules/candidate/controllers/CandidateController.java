package br.com.artfc.gestao_vagas.modules.candidate.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.artfc.gestao_vagas.modules.candidate.CandidateEntity;
import br.com.artfc.gestao_vagas.modules.candidate.useCases.CreateCandidateUseCase;
import br.com.artfc.gestao_vagas.modules.candidate.useCases.ProfileCandidateUseCase;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/candidates")
public class CandidateController {

   @Autowired
   private CreateCandidateUseCase createCandidateUseCase;

   @Autowired
   private ProfileCandidateUseCase profileCandidateUseCase;

   @PostMapping("/create")
   public ResponseEntity<Object> create(@Valid @RequestBody CandidateEntity candidate) {
      
      try{
         var result = this.createCandidateUseCase.execute(candidate);

         return ResponseEntity.ok().body(result);

      } catch(Exception e){

         return ResponseEntity.badRequest().body(e.getMessage());
         
      }
   }

   @GetMapping("/get")
   public ResponseEntity<Object> get(HttpServletRequest request) {
      
      var id = request.getAttribute("candidate_id");

      try {
         var profile = this.profileCandidateUseCase.execute(UUID.fromString(id.toString()));
         
         return ResponseEntity.ok().body(profile);
      } catch (Exception e) {
         return ResponseEntity.badRequest().body(e.getMessage());
      }
   }
   
}