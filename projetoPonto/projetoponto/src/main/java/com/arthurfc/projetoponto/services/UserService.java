package com.arthurfc.projetoponto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arthurfc.projetoponto.domain.user.User;
import com.arthurfc.projetoponto.dtos.UserDTO;
import com.arthurfc.projetoponto.repositories.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    public User findUserById(Long id) throws Exception {
        return this.userRepository.findUserById(id).orElseThrow(() -> new Exception("Usuario nao encontrado"));
    }

    public User findUserByDocument(String document) throws Exception {
        return this.userRepository.findUserByDocument(document).orElseThrow(() -> new Exception("Usuario nao encontrado"));
    }

    public User createUser(UserDTO data) {
        User newUser = new User(data);
        this.saveUser(newUser);
        return newUser;
    }

    public void saveUser(User user) {
        this.userRepository.save(user);
    }

    // public Double calculateMonthlySalary(User user, int month) {
    //     // Optional<List<Pointer>> pointers = pointerRepository.findPointersByMonth(month);
    //     // List<Pointer> listPointers = pointers.get();
        
    //     // if(listPointers.size() > 0) {
    //     //     return user.getSalary();
    //     // } else {
    //     //     return 0.;
    //     // }
    //     return 0.;
    // }
}
