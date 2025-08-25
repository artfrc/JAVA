package com.training.demo.service;

import com.training.demo.exception.ClientNotFound;
import com.training.demo.model.Client;
import com.training.demo.model.ClientResponse;
import com.training.demo.repositorie.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public ClientResponse addClient(Client c) {
        c.setRegistrationDate(LocalDate.now());
        c.setUpdateDate(LocalDate.now());
        clientRepository.save(c);
        List<Client> clientList = List.of(c);
        String message = "Customer created successfully.";
        return convertToClientResponse(message, 1, clientList);

    }

    public ClientResponse getAllClients() {
        List<Client> clientList = clientRepository.findAll();
        String message = "All customers have been retrieved.";
        return convertToClientResponse(message, clientList.size(), clientList);

    }

    public ClientResponse getClientByEmail(String email) {
        List<Client> client = Collections.singletonList(clientRepository.findByEmail(email)
                .orElseThrow(() -> new ClientNotFound("Client not found.")));

        String message = "Custumer have been retrieved.";

        return convertToClientResponse(message, 1, client);

    }

    private ClientResponse convertToClientResponse(String message, Integer sz, List<Client> list) {
        return new ClientResponse(
                message,
                sz,
                list);
    }
}
