package com.example.securityservice.entity;


import javax.persistence.*;

@Entity
@Table(name = "rooms", catalog = "office-security")
public class Rooms {
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "room_seq")
    @SequenceGenerator(name = "room_seq", sequenceName = "rooms_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "name",unique = true)
    private String roomName;

    public Rooms(){

    }

    public Long getId() {
        return id;
    }

    public String getRoomName() {
        return roomName;
    }

}
