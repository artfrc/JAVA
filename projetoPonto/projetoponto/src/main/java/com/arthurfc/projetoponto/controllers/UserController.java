package com.arthurfc.projetoponto.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arthurfc.projetoponto.domain.user.User;
import com.arthurfc.projetoponto.dtos.UserDTO;
import com.arthurfc.projetoponto.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
    
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(UserDTO user) {
        User newUser = userService.createUser(user);
        return new ResponseEntity<User>(newUser,HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = this.userService.getAllUsers();
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }
}
