package com.example.WenBadiSoff.exceptions;

public enum ErrorMessages {
    FIELD_REQUIRED("Please fill all required fields"),
    PASSWORD_NOT_STRONG("Password should include 1 small letter, 1 capital letter, and 1 special character"),
    USERNAME_EXISTS("This username is not available"),
    EMAIL_TAKEN("An account with this email already exists"),
    CAR_PLATE_UNAVAILABLE("This car plate is not available"),
    PHONE_NUMBER_TAKEN("An account with this phone number already exists")
    ;

    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
