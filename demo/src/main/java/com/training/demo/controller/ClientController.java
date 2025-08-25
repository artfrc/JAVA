package com.training.demo.controller;

import com.training.demo.model.Client;
import com.training.demo.model.ClientResponse;
import com.training.demo.service.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping
    public ResponseEntity<ClientResponse> addClient(@Valid @RequestBody  Client c) {
         return ResponseEntity.status(HttpStatus.CREATED).body(clientService.addClient(c));
    }

    @GetMapping
    public ResponseEntity<ClientResponse> getAllClients() {
        return ResponseEntity.status(HttpStatus.OK).body(clientService.getAllClients());
    }

    @GetMapping("/email")
    public ResponseEntity<ClientResponse> getClientByEmail(@RequestParam String email) {
        return ResponseEntity.status(HttpStatus.OK).body(clientService.getClientByEmail(email));
    }
}
