package med.voll.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import med.voll.api.domain.doctor.Doctor;
import med.voll.api.dtos.DoctorDTO;
import med.voll.api.repository.DoctorRepository;

@RestController
@RequestMapping("/doctors")
public class DoctorsController {
    
    @Autowired
    private DoctorRepository repository;

    @PostMapping
    @Transactional
    public void register(@RequestBody @Valid DoctorDTO data) {
        repository.save(new Doctor(data));
    }

}
