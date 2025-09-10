package com.example.WenBadiSoff.user;

import com.example.WenBadiSoff.user.model.UserLoginRequestDTO;
import com.example.WenBadiSoff.user.model.UserRegistrationRequestDTO;
import com.example.WenBadiSoff.user.services.LoginUserService;
import com.example.WenBadiSoff.user.services.RegisterUserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final RegisterUserService registerUserService;
    private final LoginUserService loginUserService;

    public UserController(RegisterUserService registerUserService, LoginUserService loginUserService) {
        this.registerUserService = registerUserService;
        this.loginUserService = loginUserService;
    }

    @PostMapping("/user/register")
    public ResponseEntity<String> registerUser(@Valid @RequestBody UserRegistrationRequestDTO userDTO) {
        return registerUserService.execute(userDTO);
    }

    @PostMapping("/user/login")
    public ResponseEntity<String> loginUser(@RequestBody UserLoginRequestDTO userDTO) {
        return loginUserService.execute(userDTO);
    }
}
