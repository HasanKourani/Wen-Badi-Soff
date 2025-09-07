package com.example.WenBadiSoff.user.services;

import com.example.WenBadiSoff.Command;
import com.example.WenBadiSoff.exceptions.ErrorMessages;
import com.example.WenBadiSoff.exceptions.UserNotValidException;
import com.example.WenBadiSoff.user.UserRepository;
import com.example.WenBadiSoff.user.model.User;
import com.example.WenBadiSoff.validators.RegisterValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class RegisterUserService implements Command<User, String> {

    private final PasswordEncoder encoder;
    private final UserRepository userRepository;

    public RegisterUserService(PasswordEncoder encoder, UserRepository userRepository) {
        this.encoder = encoder;
        this.userRepository = userRepository;
    }

    @Override
    public ResponseEntity<String> execute(User user) {

        user.setId(UUID.randomUUID());

        RegisterValidator.execute(user);

        user.setPasswordHash(encoder.encode(user.getPasswordHash()));

        Optional<User> checkEmail = userRepository.findByEmail(user.getEmail());
        Optional<User> checkUsername = userRepository.findByUsername(user.getUsername());
        Optional<User> checkPhoneNumber = userRepository.findByPhoneNumber(user.getPhoneNumber());
        Optional<User> checkCarPlate = userRepository.findByCarPlate(user.getCarPlate());

        if(checkEmail.isEmpty() && checkUsername.isEmpty() && checkPhoneNumber.isEmpty() && checkCarPlate.isEmpty()) {
            userRepository.save(user);
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
