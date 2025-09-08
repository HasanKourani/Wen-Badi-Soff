package com.example.WenBadiSoff.user.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserRegistrationRequestDTO {

    @Pattern(regexp = "^[A-Za-z][A-Za-z0-9._]{2,15}$",
    message = "Username should be 3-16 characters long, start with a letter, and can only include letters, numbers, underscores, and dots")
    @Size(min = 3, max = 16, message = "Username should be between 3 to 16 characters long")
    private String username;

    @Email
    private String email;

    @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])[A-Za-z\\d@#$%^&+=]{8,}$",
    message = "Password should be at least 8 characters long, include 1 small letter, 1 capital letter, 1 digit, and 1 special character (@#$%^&+=)")
    private String passwordHash;

    @Pattern(regexp="^(?:03|70|71|76|78|79|81)[\\s.-]?\\d{3}[\\s.-]?\\d{3}$",
    message = "Wrong phone number format")
    private String phoneNumber;

    @Pattern(regexp = "^[A-Z]\\d{1,6}$", message = "Invalid car plate format")
    private String carPlate;

    public UserRegistrationRequestDTO(String username, String email, String passwordHash, String phoneNumber, String carPlate) {
        this.username = username;
        this.email = email;
        this.passwordHash = passwordHash;
        this.phoneNumber = phoneNumber;
        this.carPlate = carPlate;
    }
}
