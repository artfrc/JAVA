package br.com.artfc.gestao_vagas.modules.company.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.artfc.gestao_vagas.modules.company.dto.CreateJobDTO;
import br.com.artfc.gestao_vagas.modules.company.entities.JobEntity;
import br.com.artfc.gestao_vagas.modules.company.useCases.CreateJobUseCase;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/job")
public class JobController {

   @Autowired
   private CreateJobUseCase createJobUseCase;

   @PostMapping("/create")
   public JobEntity create(@Valid @RequestBody CreateJobDTO job, HttpServletRequest request) {
         var companyId = request.getAttribute("company_id");
         var jobEntity = new JobEntity(
            job.getDescription(),
            job.getLevel(),
            job.getBenefits(),
            UUID.fromString(companyId.toString())
         );
         return this.createJobUseCase.execute(jobEntity);
   }
   
}
