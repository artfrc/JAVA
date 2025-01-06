package br.com.artfc.gestao_vagas.modules.company.controllers;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.artfc.gestao_vagas.modules.company.dto.CompanyDTO;
import br.com.artfc.gestao_vagas.modules.company.useCases.AuthCompanyUseCase;

@RestController
@RequestMapping("/auth")
public class AuthCompanyController {

   @Autowired
   private AuthCompanyUseCase useCase;

   @PostMapping("/company")
   public ResponseEntity<Object> create(@RequestBody CompanyDTO companyDTO) throws AuthenticationException {
      try {
         var result = this.useCase.execute(companyDTO);
         return ResponseEntity.ok().body(result);
      } catch (Exception e) {
         return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
      }
   }
   
}