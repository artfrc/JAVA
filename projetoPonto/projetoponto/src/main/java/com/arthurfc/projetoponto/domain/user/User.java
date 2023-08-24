package com.arthurfc.projetoponto.domain.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "users")
@Table(name = "users")
@Getter
@Setter
@EqualsAndHashCode(of="id") // chave primárira dessa tabela
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    
    
    private String name;
    private Double salary;
    private Integer workHoursDay;
    
    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String document;

    @Enumerated(EnumType.STRING)
    private UserType userType;
}
