package com.example.Backend.auth.controller;

import com.example.Backend.auth.model.User;
import com.example.Backend.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*") // Permite conexiones desde el frontend
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.registerUser(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        Optional<User> authenticatedUser = userService.authenticateUser(user.getUsername(), user.getPassword());
        return authenticatedUser.isPresent() ? "SUCCESS" : "ERROR";
    }
}


