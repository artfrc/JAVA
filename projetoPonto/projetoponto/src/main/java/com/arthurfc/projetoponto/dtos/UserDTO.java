package com.arthurfc.projetoponto.dtos;

import com.arthurfc.projetoponto.domain.user.UserType;

public record UserDTO(String name, Double salary, String email, String document, UserType userType) {}
