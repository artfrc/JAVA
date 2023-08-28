package com.arthurfc.projetoponto.domain.user;

import com.arthurfc.projetoponto.dtos.UserDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "users")
@Table(name = "users")
@Getter
@Setter
@EqualsAndHashCode(of="id") // chave primárira dessa tabela
@AllArgsConstructor // cria um construtor com todos os atributos da classe
@NoArgsConstructor
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
    private String document; // cpf

    @Enumerated(EnumType.STRING)
    private UserType userType;

    public User(UserDTO data) {
        this.name = data.name();
        this.salary = data.salary();
        this.document = data.document();
        this.userType = data.userType();
        this.email = data.email();
        if(data.userType() == UserType.TRAINEE) {
            this.workHoursDay = 6;
        } else {
            this.workHoursDay = 8;
        }
    }
}
