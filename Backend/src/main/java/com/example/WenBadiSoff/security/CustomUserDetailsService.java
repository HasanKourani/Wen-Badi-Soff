package com.example.WenBadiSoff.security;

import com.example.WenBadiSoff.exceptions.ErrorMessages;
import com.example.WenBadiSoff.user.UserRepository;
import com.example.WenBadiSoff.user.model.CustomUser;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String identifier) throws UsernameNotFoundException {

        CustomUser customUser = (identifier.contains("@")
                ? userRepository.findByEmail(identifier)
                : userRepository.findByUsername(identifier))
                .orElseThrow(() -> new UsernameNotFoundException(ErrorMessages.INVALID_CREDENTIALS.getMessage()));

        return User
                .withUsername(customUser.getUsername())
                .password(customUser.getPasswordHash())
                .build();
    }
}
