package com.arthurfc.projetoponto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arthurfc.projetoponto.domain.pointers.Pointer;
import com.arthurfc.projetoponto.dtos.PointerDTO;
import com.arthurfc.projetoponto.repositories.PointerRepository;

@Service
public class PointerService {
    
    @Autowired
    private PointerRepository pointerRepository;

    public List<Pointer> getAllPointers() {
        return this.pointerRepository.findAll();
    }

    public Pointer createPointer() {
        PointerDTO data = new PointerDTO();
        Pointer newPointer = new Pointer(data);
        this.savePointer(newPointer);
        return newPointer;
    }

    public void savePointer(Pointer pointer) {
        this.pointerRepository.save(pointer);
    }
}
