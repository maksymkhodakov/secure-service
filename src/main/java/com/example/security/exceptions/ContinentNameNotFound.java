package com.example.security.exceptions;

public class ContinentNameNotFound extends RuntimeException {
    public ContinentNameNotFound(String message) {
        super(message);
    }

    public ContinentNameNotFound(String message, Throwable cause) {
        super(message, cause);
    }
}
