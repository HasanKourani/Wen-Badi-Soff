package com.example.WenBadiSoff.user.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name = "users")
@Data
public class CustomUser {

    @Id
    @Column(name = "id")
    private UUID id;

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
