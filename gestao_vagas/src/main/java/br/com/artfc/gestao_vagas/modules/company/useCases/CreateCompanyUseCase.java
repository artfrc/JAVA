package br.com.artfc.gestao_vagas.modules.company.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.artfc.gestao_vagas.exceptions.UserFoundException;
import br.com.artfc.gestao_vagas.modules.company.entities.CompanyEntity;
import br.com.artfc.gestao_vagas.modules.company.repositories.CompanyRepository;

@Service
public class CreateCompanyUseCase {
   
   @Autowired
   private CompanyRepository companyRepository;

   @Autowired
   private PasswordEncoder passwordEncoder;

   public CompanyEntity execeute(CompanyEntity companyEntity) {
      
      this.companyRepository
      .findByUsernameOrEmail(companyEntity.getUsername(), companyEntity.getEmail())
      .ifPresent(company -> {
         throw new UserFoundException("Company already exists");   
      });
      
         var password = passwordEncoder.encode(companyEntity.getPassword());
         companyEntity.setPassword(password);

      return this.companyRepository.save(companyEntity);
      
   }
}
