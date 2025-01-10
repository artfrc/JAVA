package br.com.artfc.gestao_vagas.modules.candidate.dto;

public class AuthCandidateResponseDTO {
   
   private String accessToken;
   private Long expiresAt;
   
   public AuthCandidateResponseDTO(String accessToken, Long expiresAt) {
      this.accessToken = accessToken;
      this.expiresAt = expiresAt;
   }

   public AuthCandidateResponseDTO() {
   }

   public String getAccessToken() {
      return accessToken;
   }

   public void setAccessToken(String accessToken) {
      this.accessToken = accessToken;
   }

   public Long getExpiresAt() {
      return expiresAt;
   }

   public void setExpiresAt(Long expiresAt) {
      this.expiresAt = expiresAt;
   }

   

}
