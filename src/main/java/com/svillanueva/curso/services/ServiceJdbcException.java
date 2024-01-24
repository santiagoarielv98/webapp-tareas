package com.svillanueva.curso.services;

public class ServiceJdbcException extends RuntimeException {

    public ServiceJdbcException(String message, Throwable cause) {
        super(message, cause);
    }
}
