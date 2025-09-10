package com.example.WenBadiSoff.exceptions;

public enum ErrorMessages {
    FIELD_REQUIRED("Please fill all required fields"),
    PASSWORD_NOT_STRONG("Password should be at least 8 characters long, include 1 small letter, " +
            "1 capital letter, 1 digit, and 1 special character (%$#@, etc...)"),
    USERNAME_EXISTS("This username is not available"),
    EMAIL_TAKEN("An account with this email already exists"),
    CAR_PLATE_UNAVAILABLE("This car plate is not available"),
    PHONE_NUMBER_TAKEN("An account with this phone number already exists"),
    INVALID_CREDENTIALS("Invalid Credentials"),
    LOGIN_FIELDS("Enter your username or email and password to login")
    ;

    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
