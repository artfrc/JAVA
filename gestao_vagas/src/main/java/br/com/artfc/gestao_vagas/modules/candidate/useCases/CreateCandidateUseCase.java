package br.com.artfc.gestao_vagas.modules.candidate.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.artfc.gestao_vagas.exceptions.UserFoundException;
import br.com.artfc.gestao_vagas.modules.candidate.CandidateEntity;
import br.com.artfc.gestao_vagas.modules.candidate.CandidateRepository;

@Service
public class CreateCandidateUseCase {
   
   @Autowired
   private CandidateRepository candidateRepository;

   public CandidateEntity execute(CandidateEntity candidate) {
      
      this.candidateRepository
      .findByUsernameOrEmail(candidate.getUsername(), candidate.getEmail())
      .ifPresent((user) -> {
         throw new UserFoundException("User already exists");
      });

      return this.candidateRepository.save(candidate);
      
   }
}
