package com.example.security.domain.subdomain.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "advisors")
public class Advisor extends Sponsor {
    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "advisor")
    @Setter(AccessLevel.PRIVATE)
    private List<Application> applications = new ArrayList<>();

    public void assignApplication(Application application) {
        application.assignTo(this);
        applications.add(application);
    }

    enum Role {
        ASSOCIATED, PARTNER, LEAD
    }
}
