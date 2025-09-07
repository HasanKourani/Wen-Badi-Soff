package com.example.WenBadiSoff.user.services;

import com.example.WenBadiSoff.Command;
import com.example.WenBadiSoff.user.UserRepository;
import com.example.WenBadiSoff.user.model.User;
import com.example.WenBadiSoff.validators.RegisterValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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
        userRepository.save(user);

        return ResponseEntity.status(HttpStatus.CREATED).body("User Created Successfully");
    }
}
