package com.example.WenBadiSoff.user.model;

import lombok.Data;

@Data
public class UserLoginRequestDTO {

    private String username;
    private String email;
    private String password;

    public UserLoginRequestDTO(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

}
