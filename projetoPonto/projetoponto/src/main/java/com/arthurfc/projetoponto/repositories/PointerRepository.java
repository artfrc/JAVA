package com.arthurfc.projetoponto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arthurfc.projetoponto.domain.pointers.Pointer;

public interface PointerRepository extends JpaRepository<Pointer,Long> {
    
}
