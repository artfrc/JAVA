package com.training.demo.service;

import com.training.demo.model.Client;
import com.training.demo.repositorie.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public String addClient(Client c) {
        clientRepository.save(c);
        return "Client save!";
    }
}
