package med.voll.api.dtos;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.domain.doctor.Expertise;

public record DoctorDTO(
    
    @NotBlank
    String nome,
    
    @NotBlank @Email
    String email,

    @NotBlank
    String phone_number,

    @NotBlank 
    @Pattern(regexp = "\\d{4,6}") // Anotação para validar um padrão para variavel crm. O padrao é uma string de 4 a 6 digitos
    String crm,

    @NotNull // Não é @NotBlank pois esse campo não é uma String, e sim, um Enum
    Expertise expertise,

    @NotNull
    @Valid // para que o Bean Validation valide também os outros atributos do outro DTO
    AddressDTO address) {
    
}
