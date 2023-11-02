package com.spring.account.controller;

import com.spring.account.entity.User;
import com.spring.account.repository.UserRepository;
import com.spring.account.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user){
        //String encodedPassword=
        userRepository.save(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/login")
    public UUID login(@RequestParam String username, @RequestParam String password){
        return userService.getUserUUIDByUserNameAndPassword(username,password);
    }
}
