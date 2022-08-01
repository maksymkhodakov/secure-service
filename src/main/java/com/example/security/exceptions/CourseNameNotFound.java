package com.example.security.exceptions;

public class CourseNameNotFound extends RuntimeException {
    public CourseNameNotFound(String message) {
        super(message);
    }

    public CourseNameNotFound(String message, Throwable cause) {
        super(message, cause);
    }
}
