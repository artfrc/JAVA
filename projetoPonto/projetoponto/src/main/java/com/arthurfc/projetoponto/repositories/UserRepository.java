package com.arthurfc.projetoponto.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arthurfc.projetoponto.domain.user.User;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findUserById(Long id);
    Optional<User> findUserByDocument(String document);
}
