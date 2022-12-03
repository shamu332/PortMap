package com.network.backend.controller;


import com.network.backend.model.User;
import com.network.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/v1/user/login")
@RestController
public class LoginController {

    private final UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    //Check if the username exists and if the user is authorized  to log in
//    @PostMapping
//    public void getUserByUsername(@Valid @NonNull @RequestBody User user) {
//        userService.getUserByUsername(user);
//    }

}

