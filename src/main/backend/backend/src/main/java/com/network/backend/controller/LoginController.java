package com.network.backend.controller;


import com.network.backend.model.User;
import com.network.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/v1/user/login")
@RestController
public class LoginController {

    private UserService userService = null;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    //Check if the username exists and if the user is authorized  to log in
    @GetMapping
    public List<User> getUserByUsername(@Valid @NonNull @RequestBody User user) {
        return userService.getUserByUsername(user.getUsername(), user.getPassword());
    }

}

