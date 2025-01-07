package br.com.artfc.gestao_vagas.modules.company.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.artfc.gestao_vagas.modules.company.entities.CompanyEntity;
import br.com.artfc.gestao_vagas.modules.company.useCases.CreateCompanyUseCase;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/company")
public class CompanyController {

   @Autowired
   private CreateCompanyUseCase createCompanyUseCase;

   @PostMapping("/create")
   public ResponseEntity<Object> createCompany(@Valid @RequestBody CompanyEntity company) {

      try {
         var result = this.createCompanyUseCase.execute(company);

         return ResponseEntity.ok().body(result);

      }catch (Exception e) {
         return ResponseEntity.badRequest().body(e.getMessage());
      }
   }
}
