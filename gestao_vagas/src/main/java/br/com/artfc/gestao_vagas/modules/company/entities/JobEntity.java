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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "job")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
      
}
