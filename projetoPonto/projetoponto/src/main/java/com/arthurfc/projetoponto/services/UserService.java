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
        return userRepository.findAll();
    }

    public User findUserById(Long id) throws Exception {
        return userRepository.findById(id).orElseThrow(() -> new Exception("Usuario nao encontrado"));
    }

    public User createUser(UserDTO data) {
        User newUser = new User(data);
        userRepository.save(newUser);
        return newUser;
    }

    // public Double calculateMonthlySalary(User user, int month) throws Exception {
    //     findUserById(user.getId());
        
    //     Optional<List<Pointer>> pointers = pointerRepository.findPointersByMonth(month);
    //     List<Pointer> listPointers = pointers.get();
        
    //     if(listPointers.size() > 0) {
    //         return user.getSalary();
    //     } else {
    //         return 0.;
    //     }
    // }
}
