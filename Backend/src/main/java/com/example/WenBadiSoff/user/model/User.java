package com.example.WenBadiSoff.user.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "password_hash")
    private String passwordHash;

    @Column(name = "phone")
    private String phoneNumber;

    @Column(name = "car_plate")
    private String carPlate;

    @Column(name = "role")
    private String role;
}
