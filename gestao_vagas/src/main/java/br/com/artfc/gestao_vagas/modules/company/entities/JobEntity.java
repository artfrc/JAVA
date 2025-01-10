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
   private UUID companyId;
   
   @CreationTimestamp
   private LocalDate createdAt;

   public JobEntity(String description, String level, String benefits, UUID companyId) {
       this.description = description;
       this.level = level;
       this.benefits = benefits;
       this.companyId = companyId;
   }
   
   public JobEntity() {}

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

   public String getBenefits() {
      return benefits;
   }

   public void setBenefits(String benefits) {
      this.benefits = benefits;
   }

   public CompanyEntity getCompanyEntity() {
      return companyEntity;
   }

   public void setCompanyEntity(CompanyEntity companyEntity) {
      this.companyEntity = companyEntity;
   }

   public UUID getCompanyId() {
      return companyId;
   }

   public void setCompanyId(UUID companyId) {
      this.companyId = companyId;
   }

   public LocalDate getCreatedAt() {
      return createdAt;
   }

   public void setCreatedAt(LocalDate createdAt) {
      this.createdAt = createdAt;
   }

}
