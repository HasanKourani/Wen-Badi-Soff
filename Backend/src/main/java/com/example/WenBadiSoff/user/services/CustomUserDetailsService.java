package com.example.WenBadiSoff.user.services;

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
        CustomUser customUser;
        if (identifier.contains("@")) {
            customUser = userRepository.findByEmail(identifier).get();
        } else {
            customUser = userRepository.findByUsername(identifier).get();
        }

        return User
                .withUsername(String.valueOf(customUser.getId()))
                .password(customUser.getPasswordHash())
                .build();
    }
}
