package com.arthurfc.projetoponto.repositories;

import java.util.Optional;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.arthurfc.projetoponto.domain.pointers.Pointer;

public interface PointerRepository extends JpaRepository<Pointer,Long> {
    Optional<Pointer> findPointerById(Long id);
    Optional<Pointer> findLastInsertedPointer();
    
    @Query("SELECT p FROM pointers p WHERE MONTH(p.timestamp) = :month ORDER BY p.id DESC")
    Optional<List<Pointer>> findPointersByMonth(int month);
}
