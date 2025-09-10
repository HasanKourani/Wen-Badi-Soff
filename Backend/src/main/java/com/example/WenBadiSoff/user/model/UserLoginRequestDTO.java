package com.example.WenBadiSoff.user.model;

import lombok.Data;

@Data
public class UserLoginRequestDTO {

    private String identifier;
    private String password;

    public UserLoginRequestDTO(String identifier, String password) {
        this.identifier = identifier;
        this.password = password;
    }
}
