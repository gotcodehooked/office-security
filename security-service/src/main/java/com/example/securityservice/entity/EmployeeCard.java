package com.example.securityservice.entity;


import com.google.type.DateTime;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "employee_card", catalog = "office-security")
public class EmployeeCard {


    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "employee_seq")
    @SequenceGenerator(name = "employee_seq", sequenceName = "card_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "expires_in")
    private Timestamp expiresIn;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private Employee employee;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "access_id", referencedColumnName = "id")
    private Accesses accesses;

    @Column(name = "is_active")
    private boolean isActive;

    public EmployeeCard(){

    }
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setAccesses(Accesses accesses) {
        this.accesses = accesses;
    }

    public void setActive(boolean active) {
        isActive = active;
    }


    public Long getId() {
        return id;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public Timestamp getExpiresIn() {
        return expiresIn;
    }

    public Employee getEmployee() {
        return employee;
    }

    public Accesses getAccesses() {
        return accesses;
    }

    public boolean isActive() {
        return isActive;
    }


}
