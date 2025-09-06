package com.example.WenBadiSoff.validators;

import com.example.WenBadiSoff.exceptions.ErrorMessages;
import com.example.WenBadiSoff.exceptions.UserNotValidException;
import com.example.WenBadiSoff.user.model.User;
import com.mysql.cj.util.StringUtils;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class RegisterValidator {

    public static void execute(User user) {

        if(StringUtils.isEmptyOrWhitespaceOnly(user.getUsername())
        || StringUtils.isEmptyOrWhitespaceOnly(user.getEmail())
        || StringUtils.isEmptyOrWhitespaceOnly(user.getPasswordHash())
        || StringUtils.isEmptyOrWhitespaceOnly(user.getCarPlate())
        || StringUtils.isEmptyOrWhitespaceOnly(user.getPhoneNumber())) {
            throw new UserNotValidException(ErrorMessages.FIELD_REQUIRED.getMessage());
        }
    }
}
