package com.example.WenBadiSoff.user.services;

import com.example.WenBadiSoff.Command;
import com.example.WenBadiSoff.user.UserRepository;
import com.example.WenBadiSoff.user.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class RegisterUserService implements Command<User, String> {

    private final UserRepository userRepository;

    public RegisterUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public ResponseEntity<String> execute(User user) {
        user.setId(UUID.randomUUID());
        userRepository.save(user);

        return ResponseEntity.status(HttpStatus.CREATED).body("User Created Successfully");
    }
}
