package med.voll.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import med.voll.api.domain.patient.Patient;

public interface PatientRepository extends JpaRepository<Patient,Long> {
    
}
