package br.com.artfc.gestao_vagas.modules.candidate.dto;

import java.util.UUID;

public record ProfileCandidateDTO(
   String description,
   String username,
   String email,
   UUID id,
   String name) {
   
}
