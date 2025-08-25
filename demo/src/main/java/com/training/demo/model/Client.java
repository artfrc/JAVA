package com.training.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "Clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank(message = "name is mandatory.")
    private String name;

    @NotBlank(message = "email is mandatory.")
    // TO DO: arrumar a mensagem de erro quando essa anotacao for violada
    @Email(message = "Invalid email.")
    @Column(unique = true)
    private String email;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate registrationDate;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate updateDate;

    public Client() {}

    public Client(String name, String email) {
        this.name = name;
        this.email = email;
        this.registrationDate = LocalDate.now();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate){
        this.registrationDate = registrationDate;
    }

    public LocalDate getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDate updateDate) {
        this.updateDate = updateDate;
    }
}
