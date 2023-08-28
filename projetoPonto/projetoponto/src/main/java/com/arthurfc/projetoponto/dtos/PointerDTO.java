package com.arthurfc.projetoponto.dtos;

import java.time.LocalDateTime;

import com.arthurfc.projetoponto.domain.user.User;

public record PointerDTO(LocalDateTime timestamp, User user) {}
