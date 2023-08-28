package com.arthurfc.projetoponto.domain.pointers;

import java.time.LocalDateTime;

import com.arthurfc.projetoponto.dtos.PointerDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "pointers")
@Table(name = "pointers")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
public class Pointer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime timestamp;

    @Column(name = "user_id")
    private Long userId;

    public Pointer(PointerDTO data) {
        this.timestamp = data.timestamp();
        this.userId = data.userId();
    }
}
