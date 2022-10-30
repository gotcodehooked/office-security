package com.example.securityservice.entity;

import javax.persistence.*;

@Entity
@Table(name = "sections", catalog = "office-security")
public class Sections {
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "sections_seq")
    @SequenceGenerator(name = "sections_seq", sequenceName = "sections_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "name", unique = true, nullable = false)
    private String sectionName;

    public Sections() {

    }

    public Long getId() {
        return id;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }
}
