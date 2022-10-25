package com.example.securityservice.entity;

import javax.persistence.*;
@Entity
@Table(name = "employee", catalog = "office-security")
public class Employee {
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "id_seq")
    @SequenceGenerator(name = "id_seq", sequenceName = "employee_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "firstname", nullable = false)
    private String firstName;

    @Column(name = "lastname", nullable = false)
    private String lastName;

    public Employee() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
