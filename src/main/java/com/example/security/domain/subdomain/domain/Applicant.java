package com.example.security.domain.subdomain.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "applicants")
public class Applicant extends Sponsor {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String ssn;

    @Embedded
    private Address address;

    @ElementCollection
    @CollectionTable(name = "applicant_phones", joinColumns = @JoinColumn(name = "applicant_id"),
            indexes = @Index(name = "application_phones_applicant_id_idx", columnList = "applicant_id"))
    private List<Phone> phoneList = new ArrayList<>();
}
