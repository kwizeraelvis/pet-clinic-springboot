package com.elvis.springapp.petclinic.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@Setter
@Getter
@MappedSuperclass
@NoArgsConstructor
public class Person extends BaseEntity {
    @Column(name = "firt_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;

    public Person(Long id, String firstname, String lastname) {
        super(id);
        this.firstName = firstname;
        this.lastName = lastname;
    }
}
