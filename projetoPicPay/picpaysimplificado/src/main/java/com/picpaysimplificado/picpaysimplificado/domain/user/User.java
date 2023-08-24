package com.picpaysimplificado.picpaysimplificado.domain.user;

import java.math.BigDecimal;

import com.picpaysimplificado.dtos.UserDTO;

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
import lombok.Setter;

@Entity(name = "users") // para representar uma entidade do banco de dados
@Table(name = "users") // para representar uma tabela do banco de dados
@Setter
@Getter
@AllArgsConstructor // cria um construtor com todos os atributos da classe
@EqualsAndHashCode(of="id") // chave primária dessa entidade/tabela

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // gera Ids automaticamente de forma incremental (1,2,3,4,5...)
    private Long id;
    
    private String firstName;
    private String lastName;
    
    @Column(unique = true)
    private String document; // essa coluna da tabela é única

    @Column(unique = true)
    private String email;

    private String password;
    private BigDecimal balance; // saldo da conta

    @Enumerated(EnumType.STRING) // para representar COMMON ou MERCHANT como String
    private UserType userType;

    public User(UserDTO data) {
        this.firstName = data.firstName();
        this.lastName = data.lastName();
        this.document = data.document();
        this.balance = data.balance();
        this.userType = data.userType();
        this.password = data.password();
        this.email = data.email();
    }
}
