package br.com.artfc.gestao_vagas.modules.company.dto;


public class AuthCompanyResponseDTO {

   private String accessToken;
   private Long expiresAt;
   
   public AuthCompanyResponseDTO(String accessToken, Long expiresAt) {
      this.accessToken = accessToken;
      this.expiresAt = expiresAt;
   }

   public AuthCompanyResponseDTO() {
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
