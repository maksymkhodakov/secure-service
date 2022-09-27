package com.example.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class SecureUserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecureUserServiceApplication.class, args);
    }

}
