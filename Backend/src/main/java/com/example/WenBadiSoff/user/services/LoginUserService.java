package com.example.WenBadiSoff.user.services;

import com.example.WenBadiSoff.Command;
import com.example.WenBadiSoff.security.JwtUtil;
import com.example.WenBadiSoff.user.model.UserLoginRequestDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

@Service
public class LoginUserService implements Command<UserLoginRequestDTO, String> {

    private final AuthenticationManager manager;

    public LoginUserService(AuthenticationManager manager) {
        this.manager = manager;
    }

    @Override
    public ResponseEntity<String> execute(UserLoginRequestDTO userDTO) {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
                userDTO.getIdentifier(),
                userDTO.getPassword()
        );

        Authentication authentication = manager.authenticate(token);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwtToken = JwtUtil.generateToken((User) authentication.getPrincipal());

        return ResponseEntity.ok(jwtToken);
    }
}
