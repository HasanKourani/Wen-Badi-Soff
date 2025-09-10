package com.example.WenBadiSoff.validators;

import com.example.WenBadiSoff.exceptions.ErrorMessages;
import com.example.WenBadiSoff.exceptions.UserNotValidException;
import com.example.WenBadiSoff.user.model.CustomUser;
import com.mysql.cj.util.StringUtils;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class RegisterValidator {

    public static void execute(CustomUser customUser) {

        if(StringUtils.isEmptyOrWhitespaceOnly(customUser.getUsername())
        || StringUtils.isEmptyOrWhitespaceOnly(customUser.getEmail())
        || StringUtils.isEmptyOrWhitespaceOnly(customUser.getPasswordHash())
        || StringUtils.isEmptyOrWhitespaceOnly(customUser.getCarPlate())
        || StringUtils.isEmptyOrWhitespaceOnly(customUser.getPhoneNumber())) {
            throw new UserNotValidException(ErrorMessages.FIELD_REQUIRED.getMessage());
        }
    }
}
