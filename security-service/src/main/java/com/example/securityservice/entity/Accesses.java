package com.example.securityservice.entity;

import javax.persistence.*;

@Entity
@Table(name = "accesses",catalog = "office-security")
public class Accesses {

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "accesses_seq")
    @SequenceGenerator(name = "accesses_seq", sequenceName = "accesses_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "md5_access_code",unique = true)
    private String md5_access_code;

    public Accesses(){

    }

    public Long getId() {
        return id;
    }

    public String getMd5_access_code() {
        return md5_access_code;
    }

}
