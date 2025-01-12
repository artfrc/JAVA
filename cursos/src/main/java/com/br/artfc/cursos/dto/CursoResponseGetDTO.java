package com.br.artfc.cursos.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public record CursoResponseGetDTO(UUID id, String name, String category, Boolean active, LocalDateTime createdAt) {
   
}
