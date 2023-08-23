package com.picpaysimplificado.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.picpaysimplificado.picpaysimplificado.domain.user.User;

// Repositorios são usados para fazer operações com o banco de dados (as consultas)

public interface UserRepository extends JpaRepository<User, Long>{
    Optional<User> findUserByDocument(String document); // Optional é usado para evitar o NullPointerException, pois pode ou não ter um usuário com o documento informado

    /*                          ======================>> IMPORTANTE <<====================== 
        Note que a função está somente declarada, não tem um corpo. Isso porque o JPA é inteligente suficiente para entender oque essa função deve fazer devido o seu nome (findUser => procurar usuário | ByDocument => procurar pelo documento) 
                                ======================>> IMPORTANTE <<======================          */

    Optional<User> findUserById(Long id);
} 
