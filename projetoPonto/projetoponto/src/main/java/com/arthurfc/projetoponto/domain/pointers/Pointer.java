package com.arthurfc.projetoponto.domain.pointers;

import java.time.LocalDateTime;

import com.arthurfc.projetoponto.domain.user.User;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "pointers")
@Table(name = "pointers")
@Getter
@Setter
@EqualsAndHashCode(of="id")
@AllArgsConstructor // cria um construtor com todos os atributos da classe
public class Pointer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime timestamp;
    
    @Enumerated(EnumType.STRING)
    private TypePointer typePointer;

    // Um usuário pode ter vários pontos mas um ponto pode ter apenas um usuário
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
