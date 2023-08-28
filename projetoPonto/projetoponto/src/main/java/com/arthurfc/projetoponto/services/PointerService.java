package com.arthurfc.projetoponto.services;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arthurfc.projetoponto.domain.pointers.Pointer;
import com.arthurfc.projetoponto.domain.user.User;
import com.arthurfc.projetoponto.dtos.PointerDTO;
import com.arthurfc.projetoponto.repositories.PointerRepository;

@Service
public class PointerService {
    
    @Autowired
    private PointerRepository pointerRepository;

    public List<Pointer> getAllPointers() {
        return pointerRepository.findAll();
    }

    public List<Pointer> getAllPointersMonth(int month) {
        return pointerRepository.findPointersByMonth(month);
    }

    public Pointer createPointer(User user) throws Exception {

        LocalDateTime currentTime = LocalDateTime.now();

        LocalTime startTime = LocalTime.of(8, 0); // Início do período
        LocalTime endTime = LocalTime.of(17, 29); // Fim do período

        // Verifique se currentTime está dentro do período
        LocalTime currentTimeOnly = currentTime.toLocalTime();
        boolean isWithinPeriod = !currentTimeOnly.isBefore(startTime) && !currentTimeOnly.isAfter(endTime);

        if (isWithinPeriod) {
            PointerDTO data = new PointerDTO(currentTime,user);
            Pointer newPointer = new Pointer(data);
            pointerRepository.save(newPointer);
            return newPointer;
        } else {
            throw new IllegalStateException("Fora do período permitido para criar um Pointer");
        }
    }

}
