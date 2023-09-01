package med.voll.api.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record AddressDTO(
    
    @NotBlank
    String patio, 
    
    @NotBlank
    String neighborhood, 
    
    @NotBlank
    @Pattern(regexp = "\\d{8}") // sao 8 digitos que compoe o cep
    String zipcode, 
    
    @NotBlank
    String city, 
    
    @NotBlank
    String uf, 
    
    String numero, 
    String complement) {
    
}
