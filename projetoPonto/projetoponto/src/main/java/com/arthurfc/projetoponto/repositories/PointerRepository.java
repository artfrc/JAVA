package com.arthurfc.projetoponto.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.arthurfc.projetoponto.domain.pointers.Pointer;

public interface PointerRepository extends JpaRepository<Pointer,Long> {
    @Query("SELECT p FROM pointers p WHERE MONTH(p.timestamp) = :month")
    List<Pointer> findPointersByMonth(@Param("month") int month);
}
