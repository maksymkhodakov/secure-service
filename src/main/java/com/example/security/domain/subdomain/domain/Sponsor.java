package com.example.security.domain.subdomain.domain;

import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Inheritance;

@EqualsAndHashCode(of = "cognitoUsername")
@Inheritance
public abstract class Sponsor {
    @Column(nullable = false, updatable = false, unique = true)
    private String cognitoUsername;

    @Column(nullable = false, unique = true)
    private String email;
}
