package com.example.WenBadiSoff.exceptions;

import com.example.WenBadiSoff.user.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorResponse handleUserNotValidException(UserNotValidException exception) {
        return new ErrorResponse(exception.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorResponse handlePasswordValidation(MethodArgumentNotValidException exception) {
        HashMap<String, String> errorList = new HashMap<>();
        for(FieldError error : exception.getBindingResult().getFieldErrors()) {
            errorList.put(error.getField(), error.getDefaultMessage());
        }
        return new ErrorResponse(errorList);
    }
}
