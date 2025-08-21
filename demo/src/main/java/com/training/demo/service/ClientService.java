package com.training.demo.service;

import com.training.demo.model.Client;
import com.training.demo.model.ClientResponse;
import com.training.demo.repositorie.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public ClientResponse addClient(Client c) {
        clientRepository.save(c);
        List<Client> clientList = List.of(c);
        return new ClientResponse(
                "Client created succesfully.",
                HttpStatus.CREATED.value(),
                clientList.size(),
                clientList);
    }

    public ClientResponse getAllClients() {
        List<Client> clientList = clientRepository.findAll();
        return new ClientResponse(
                "All customers were picked up",
                HttpStatus.OK.value(),
                clientList.size(),
                clientList);
    }
}
