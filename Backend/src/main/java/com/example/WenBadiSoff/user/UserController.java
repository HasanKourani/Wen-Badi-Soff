package com.example.WenBadiSoff.user;

import com.example.WenBadiSoff.user.model.User;
import com.example.WenBadiSoff.user.services.RegisterUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final RegisterUserService registerUserService;

    public UserController(RegisterUserService registerUserService) {
        this.registerUserService = registerUserService;
    }


    @PostMapping("/user/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        return registerUserService.execute(user);
    }
}
