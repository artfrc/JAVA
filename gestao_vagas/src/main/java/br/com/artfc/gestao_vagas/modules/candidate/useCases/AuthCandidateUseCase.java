package br.com.artfc.gestao_vagas.modules.candidate.useCases;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import br.com.artfc.gestao_vagas.modules.candidate.CandidateRepository;
import br.com.artfc.gestao_vagas.modules.candidate.dto.AuthCandidateRequestDTO;
import br.com.artfc.gestao_vagas.modules.candidate.dto.AuthCandidateResponseDTO;

@Service
public class AuthCandidateUseCase {

   @Autowired
   private CandidateRepository candidateRepository;

   @Autowired
   private PasswordEncoder passwordEncoder;

   @Value("${security.token.secret.candidate}")
   private String secretKey;

   public AuthCandidateResponseDTO execute(AuthCandidateRequestDTO request) throws AuthenticationException {
      var candidate = this.candidateRepository.findByUsername(request.username())
         .orElseThrow(() -> {
            throw new UsernameNotFoundException("Username/Password not found");
         });

      var passwordMatch = this.passwordEncoder
         .matches(request.password(), candidate.getPassword());

         if(!passwordMatch) {
            throw new AuthenticationException();
         }

         Algorithm algorithm = Algorithm.HMAC256(secretKey);
         var expireAt = Instant.now().plus(Duration.ofMinutes(10));
         var token = JWT.create()
         .withExpiresAt(expireAt)
         .withClaim("roles", Arrays.asList("CANDIDATE"))
         .withIssuer("javagas")
         .withSubject(candidate.getId().toString())
         .sign(algorithm);

      var authCandidateResponse = new AuthCandidateResponseDTO(token, expireAt.toEpochMilli());

         return authCandidateResponse;
   }
   
}