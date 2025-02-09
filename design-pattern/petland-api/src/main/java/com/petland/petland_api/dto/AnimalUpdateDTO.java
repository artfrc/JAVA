package com.petland.petland_api.dto;

import java.time.LocalDate;
import java.util.Optional;

import org.hibernate.validator.constraints.Length;

import com.petland.petland_api.model.AnimalEspecie;

import jakarta.validation.constraints.PastOrPresent;

public record AnimalUpdateDTO(

@Length(max = 50, message = "Nome deve ter no máximo 50 caracteres")
Optional<String> nome,

@PastOrPresent(message = "Aniversário deve ser no passado ou presente")
Optional<LocalDate> aniversario,

Optional<AnimalEspecie> especie
) {
   
}
