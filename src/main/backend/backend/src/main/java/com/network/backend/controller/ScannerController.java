//package com.network.backend.controller;
//
//import com.network.backend.model.User;
//import com.network.backend.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.lang.NonNull;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//import java.util.List;
//import java.util.UUID;
//
//@CrossOrigin(origins = "http://localhost:3000")
//@RequestMapping("api/v1/user")
//@RestController
//public class ScannerController {
//
//    private final Scanner scannerServices;
//
//    @Autowired
//    public UserController(UserService userService) {
//        this.userService = userService;
//    }
//
//    @PostMapping
//    public void addUser(@Valid @NonNull @RequestBody User user) {
//        userService.addUser(user);
//    }
//
//    @DeleteMapping(path = "{id}")
//    public void deleteUserById(@PathVariable("id") UUID id) {
//        userService.deleteUser(id);
//    }
//
//    @PutMapping(path = "{id}")
//    public void updateUser(@PathVariable("id") UUID id, @Valid @NonNull @RequestBody User userToUpdate) {
//        userService.updateUser(id, userToUpdate);
//    }
//}