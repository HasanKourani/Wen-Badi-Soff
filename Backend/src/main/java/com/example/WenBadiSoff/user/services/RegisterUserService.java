package com.example.WenBadiSoff.user.services;

import com.example.WenBadiSoff.Command;
import com.example.WenBadiSoff.exceptions.ErrorMessages;
import com.example.WenBadiSoff.exceptions.UserNotValidException;
import com.example.WenBadiSoff.user.UserRepository;
import com.example.WenBadiSoff.user.model.CustomUser;
import com.example.WenBadiSoff.user.model.UserRegistrationRequestDTO;
import com.example.WenBadiSoff.validators.RegisterValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class RegisterUserService implements Command<UserRegistrationRequestDTO, String> {

    private final PasswordEncoder encoder;
    private final UserRepository userRepository;

    public RegisterUserService(PasswordEncoder encoder, UserRepository userRepository) {
        this.encoder = encoder;
        this.userRepository = userRepository;
    }

    @Override
    public ResponseEntity<String> execute(UserRegistrationRequestDTO userDTO) {

        CustomUser customUser = new CustomUser();
        customUser.setId(UUID.randomUUID());
        customUser.setUsername(userDTO.getUsername());
        customUser.setEmail(userDTO.getEmail());
        customUser.setPasswordHash(userDTO.getPasswordHash());
        customUser.setPhoneNumber(userDTO.getPhoneNumber());
        customUser.setCarPlate(userDTO.getCarPlate());
        customUser.setRole("USER");

        RegisterValidator.execute(customUser);

        customUser.setPasswordHash(encoder.encode(customUser.getPasswordHash()));

        Optional<CustomUser> checkEmail = userRepository.findByEmail(customUser.getEmail());
        Optional<CustomUser> checkUsername = userRepository.findByUsername(customUser.getUsername());
        Optional<CustomUser> checkPhoneNumber = userRepository.findByPhoneNumber(customUser.getPhoneNumber());
        Optional<CustomUser> checkCarPlate = userRepository.findByCarPlate(customUser.getCarPlate());

        if(checkEmail.isEmpty() && checkUsername.isEmpty() && checkPhoneNumber.isEmpty() && checkCarPlate.isEmpty()) {
            userRepository.save(customUser);
            return ResponseEntity.status(HttpStatus.CREATED).body("User Created Successfully");
        }

        if(checkEmail.isPresent()) {
            throw new UserNotValidException(ErrorMessages.EMAIL_TAKEN.getMessage());
        } else if(checkUsername.isPresent()) {
            throw new UserNotValidException(ErrorMessages.USERNAME_EXISTS.getMessage());
        } else if(checkPhoneNumber.isPresent()) {
            throw new UserNotValidException(ErrorMessages.PHONE_NUMBER_TAKEN.getMessage());
        } else {
            throw new UserNotValidException(ErrorMessages.CAR_PLATE_UNAVAILABLE.getMessage());
        }
    }
}
