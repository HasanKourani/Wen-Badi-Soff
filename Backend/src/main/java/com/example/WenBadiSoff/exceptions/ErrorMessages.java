package com.example.WenBadiSoff.exceptions;

public enum ErrorMessages {
    FIELD_REQUIRED("Please fill all required fields"),
    ;

    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
