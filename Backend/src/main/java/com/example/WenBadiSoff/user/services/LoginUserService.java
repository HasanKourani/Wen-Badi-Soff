package com.example.WenBadiSoff.user.services;

import com.example.WenBadiSoff.Command;
import com.example.WenBadiSoff.user.UserRepository;
import com.example.WenBadiSoff.user.model.UserLoginRequestDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class LoginUserService implements Command<UserLoginRequestDTO, String> {

    private final UserRepository userRepository;

    public LoginUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public ResponseEntity<String> execute(UserLoginRequestDTO input) {
        return null;
    }
}
