package com.petland.petland_api.dto;

import java.time.LocalDate;

import org.hibernate.validator.constraints.Length;

import com.petland.petland_api.model.AnimalEspecie;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

public record AnimalRequestDTO(

   @NotBlank(message = "Nome é obrigatório")
   @Length(max = 50, message = "Nome deve ter no máximo 50 caracteres")
   String nome,

   @PastOrPresent(message = "Aniversário deve ser no passado ou presente")
   LocalDate aniversario,
   
   @NotNull(message = "Especie é obrigatória")
   AnimalEspecie especie) {
   
}
