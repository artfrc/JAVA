package br.com.artfc.gestao_vagas.modules.company.entities;

import java.time.LocalDate;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity(name = "job")
public class JobEntity {

   @Id
   @GeneratedValue(strategy = GenerationType.UUID)
   private UUID id;
   private String description;

   @NotBlank(message = "Level is mandatory")
   private String level;
   private String benefits;

   @ManyToOne
   @JoinColumn(name = "company_id", insertable = false, updatable = false)
   private CompanyEntity companyEntity;

   @Column(name = "company_id")
   @NotNull(message = "Company is mandatory")
   private UUID companyId;

   @CreationTimestamp
   private LocalDate createdAt;

   public UUID getId() {
      return id;
   }

   public void setId(UUID id) {
      this.id = id;
   }

   public String getDescription() {
      return description;
   }

   public void setDescription(String description) {
      this.description = description;
   }

   public String getLevel() {
      return level;
   }

   public void setLevel(String level) {
      this.level = level;
   }

   public UUID getCompanyId() {
      return companyId;
   }

   public void setCompanyId(UUID companyId) {
      this.companyId = companyId;
   }

   public String getBenefits() {
      return benefits;
   }

   public void setBenefits(String benefits) {
      this.benefits = benefits;
   }

   public LocalDate getCreatedAt() {
      return createdAt;
   }

   public void setCreatedAt(LocalDate createdAt) {
      this.createdAt = createdAt;
   }
   
}
