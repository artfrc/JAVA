package com.training.demo.exception;

public class ClientNotFound extends RuntimeException{

    public ClientNotFound(String message) {
        super(message);
    }
}
