package com.example.security.exceptions;

public class StudentSurnameNotFound extends RuntimeException {
    public StudentSurnameNotFound(String message) {
        super(message);
    }

    public StudentSurnameNotFound(String message, Throwable cause) {
        super(message, cause);
    }
}
