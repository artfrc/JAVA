package br.com.artfc.gestao_vagas.modules.company.useCases;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import br.com.artfc.gestao_vagas.exceptions.UserFoundException;
import br.com.artfc.gestao_vagas.modules.company.dto.AuthCompanyResponseDTO;
import br.com.artfc.gestao_vagas.modules.company.dto.CompanyDTO;
import br.com.artfc.gestao_vagas.modules.company.repositories.CompanyRepository;

@Service
public class AuthCompanyUseCase {

   @Autowired
   private CompanyRepository repository;

   @Autowired
   private PasswordEncoder passwordEncoder;

   @Value("${security.token.secret}")
   private String secretKey; 

   public AuthCompanyResponseDTO execute(CompanyDTO companyDTO) throws AuthenticationException {

      var company = this.repository.findByUsername(companyDTO.getUsername())
         .orElseThrow(() -> {
            throw new UserFoundException("Company/password not found");
         });

      var passwordMatches = this.passwordEncoder.matches(companyDTO.getPassword(), company.getPassword());

      if (!passwordMatches) {
         throw new AuthenticationException("Company/password not found");
      } else {
         Algorithm algorithm = Algorithm.HMAC256(secretKey);

         var expiresAt = Instant.now().plus(Duration.ofHours(2));

         var token = JWT.create().withIssuer("javagas")
         .withExpiresAt(Instant.now().plus(Duration.ofHours(2)))
            .withSubject(company.getId().toString())
            .withExpiresAt(expiresAt)
            .withClaim("roles", Arrays.asList("COMPANY"))
            .sign(algorithm);

         AuthCompanyResponseDTO response = new AuthCompanyResponseDTO(
            token,
            expiresAt.toEpochMilli());

         return response;
      }
   }
}
