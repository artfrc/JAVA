package med.voll.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.domain.patient.Patient;
import med.voll.api.dtos.PatientDTO;
import med.voll.api.repository.PatientRepository;

@RestController
@RequestMapping("/pacientes")
public class PatientsController {
    
    @Autowired
    private PatientRepository repository;

    @PostMapping
    @Transactional
    public void register(@RequestBody @Valid PatientDTO data) {
        repository.save(new Patient(data));
    }   
}
