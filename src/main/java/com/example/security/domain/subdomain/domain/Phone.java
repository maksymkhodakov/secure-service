package com.example.security.domain.subdomain.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@NoArgsConstructor
@Embeddable
public class Phone {
    @Column(nullable = false)
    private String number;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Type type;

    enum Type {
        HOME, WORK, MOBILE
    }
}
