package com.ms.user.services;

import com.ms.user.models.UserDTO;
import com.ms.user.models.UserModel;
import com.ms.user.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Transactional
    public UserModel saveUser(UserDTO userDTO) {
        var userModel = new UserModel();
        BeanUtils.copyProperties(userDTO, userModel);

        repository.save(userModel);

        return userModel;
    }
}
