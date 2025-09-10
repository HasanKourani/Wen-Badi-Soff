package com.example.WenBadiSoff.validators;

import com.example.WenBadiSoff.exceptions.ErrorMessages;
import com.example.WenBadiSoff.exceptions.UserNotValidException;
import com.example.WenBadiSoff.user.model.UserLoginRequestDTO;
import com.mysql.cj.util.StringUtils;

public class LoginValidator {

    public static void execute(UserLoginRequestDTO userDTO) {
        if(StringUtils.isEmptyOrWhitespaceOnly(userDTO.getIdentifier())
        || StringUtils.isEmptyOrWhitespaceOnly(userDTO.getPassword())) {
            throw new UserNotValidException(ErrorMessages.LOGIN_FIELDS.getMessage());
        }
    }
}
