package med.voll.api.domain.address;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import med.voll.api.dtos.AddressDTO;

@Embeddable
@Getter
@Setter
@NoArgsConstructor 
@AllArgsConstructor
public class DataAddress {
    
    private String patio;
    private String neighborhood;
    private String zipcode;
    private String city;
    private String uf;
    private String numero;
    private String complement;

    public DataAddress(AddressDTO data) {
        this.patio = data.patio();
        this.neighborhood = data.neighborhood();
        this.zipcode = data.zipcode();
        this.city = data.city();
        this.uf = data.uf();
        this.numero = data.numero();
        this.complement = data.complement();
    }

}
