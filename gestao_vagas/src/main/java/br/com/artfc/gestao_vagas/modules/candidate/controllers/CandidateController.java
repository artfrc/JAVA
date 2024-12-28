package br.com.artfc.gestao_vagas.modules.candidate.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.artfc.gestao_vagas.modules.candidate.CandidateEntity;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/candidates")
public class CandidateController {

   @PostMapping("/create")
   public void create(@Valid @RequestBody CandidateEntity candidate) {
      System.out.println("Candidate: " + candidate.getEmail());
   }
   
}