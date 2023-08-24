package com.arthurfc.projetoponto.services;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arthurfc.projetoponto.domain.pointers.Pointer;
import com.arthurfc.projetoponto.domain.pointers.PointerType;
import com.arthurfc.projetoponto.domain.user.User;
import com.arthurfc.projetoponto.repositories.PointerRepository;

@Service
public class PointerService {
    
    @Autowired
    private PointerRepository repository;

    public void createPointer(User user) throws Exception {
        LocalDateTime currentTime = LocalDateTime.now();
        LocalTime startTime = LocalTime.of(8,0); // inicia às 8:00
        LocalTime endTime = LocalTime.of(17,30); // termina às 17:30
        boolean allowedTime = currentTime.toLocalTime().isAfter(startTime) && currentTime.toLocalTime().isBefore(endTime);

        if(!allowedTime) {
            throw new Exception("Erro! Fora do horario de servico");
        }

        // Criar novo ponto na tabela
        Pointer newPointer = new Pointer();
        newPointer.setTimestamp(currentTime);
        newPointer.setUser(user);

        Optional<Pointer> lastPointer = repository.findLastInsertedPointer();

        if(lastPointer.isPresent()) {
            Pointer pointer = lastPointer.get();
            if(pointer.getTypePointer() == PointerType.START) {
                newPointer.setTypePointer(PointerType.FINISH);
            } else {
                newPointer.setTypePointer(PointerType.START);
            }
        } else {
            newPointer.setTypePointer(PointerType.START);
        }

        this.repository.save(newPointer); // Salvar novo ponto
    }

}
