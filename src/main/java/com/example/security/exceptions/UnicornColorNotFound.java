package com.example.security.exceptions;

public class UnicornColorNotFound extends RuntimeException {
    public UnicornColorNotFound(String message) {
        super(message);
    }

    public UnicornColorNotFound(String message, Throwable cause) {
        super(message, cause);
    }
}
