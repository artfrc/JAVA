package med.voll.api.dtos;

import med.voll.api.domain.doctor.Doctor;
import med.voll.api.domain.doctor.Expertise;

public record DataGetDoctorsDTO(String nome, String email, String crm, Expertise expertise) {

    public DataGetDoctorsDTO(Doctor data) {
        this(data.getNome(), data.getEmail(), data.getCrm(), data.getExpertise());
    }
}
