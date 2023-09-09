package med.voll.api.dtos;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record PatientDTO(

    @NotBlank
    String nome,

    @NotBlank
    String email,

    @NotBlank
    String phone,

    @NotBlank @Pattern(regexp = "\\d{3}\\.?\\d{3}\\.?\\d{3}\\-?\\d{2}")
    String cpf,

    @NotNull
    @Valid
    AddressDTO address) {
    
}
