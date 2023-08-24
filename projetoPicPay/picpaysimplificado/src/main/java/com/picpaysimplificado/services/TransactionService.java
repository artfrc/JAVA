package com.picpaysimplificado.services;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate; 

import com.picpaysimplificado.dtos.TransactionDTO;
import com.picpaysimplificado.picpaysimplificado.domain.transaction.Transaction;
import com.picpaysimplificado.picpaysimplificado.domain.user.User;
import com.picpaysimplificado.repositories.TransactionRepository;

@Service
public class TransactionService {
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private TransactionRepository repository;

    @Autowired
    private RestTemplate restTemplate; // Classe para fazer requisições HTTP

    public void createTransaction(TransactionDTO transaction) throws Exception {
        User sender = this.userService.findUserById(transaction.senderId());
        User receiver = this.userService.findUserById(transaction.receiverId());

        userService.validateTransaction(sender, transaction.value());

        boolean isAutorized = this.authorizeTransaction(sender, transaction.value());
        
        if(!isAutorized) {
            throw new Exception("Transaction not authorized");
        }

        // Criar uma nova transação na tabela
        Transaction newTransaction = new Transaction();
        newTransaction.setAmount(transaction.value());
        newTransaction.setSender(sender);
        newTransaction.setReceiver(receiver);
        newTransaction.setTimestamp(LocalDateTime.now());

        // Atualizar saldos
        sender.setBalance(sender.getBalance().subtract(transaction.value()));
        receiver.setBalance(receiver.getBalance().add(transaction.value()));

        // Salvar transação e atualizar saldos
        this.repository.save(newTransaction);
        this.userService.saveUser(sender);
        this.userService.saveUser(receiver);
    }

    public boolean authorizeTransaction(User sender, BigDecimal value) {
       ResponseEntity<Map> authorizationResponse = restTemplate.getForEntity("https://run.mocky.io/v3/8fafdd68-a090-496f-8c9a-3442cf30dae6", Map.class);
        
       // Se o status code for OK, ou seja, retornar 200 e a mensagem for "Autorizado", retorna true ("Autorizado pois o proprio mock diz que é autorizado")
       if(authorizationResponse.getStatusCode() == HttpStatus.OK) {
            String message = authorizationResponse.getBody().get("message").toString();
            return "Autorizado".equalsIgnoreCase(message);
        } else {
            return false;
       }
    }
}
