package med.voll.api.domain.patient;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import med.voll.api.domain.address.DataAddress;
import med.voll.api.dtos.PatientDTO;

@Table(name = "pacientes")
@Entity(name = "Patient")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Patient {  

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String phone;
    private String cpf;
    
    @Embedded
    private DataAddress address;

    public Patient(PatientDTO data) {
        this.cpf = data.cpf();
        this.nome = data.nome();
        this.email = data.email();
        this.phone = data.phone();
        this.address = new DataAddress(data.address());
    }

}
