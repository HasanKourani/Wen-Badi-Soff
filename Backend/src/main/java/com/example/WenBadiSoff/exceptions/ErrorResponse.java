package com.example.WenBadiSoff.exceptions;

import lombok.Getter;

import java.util.Map;

@Getter
public class ErrorResponse {

    private String message;
    private Map<String, String> errors;

    public ErrorResponse(String message) {
        this.message = message;
    }

    public ErrorResponse(Map<String, String> errors) {
        this.errors = errors;
    }
}
