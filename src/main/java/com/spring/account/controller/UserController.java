package com.spring.account.controller;

import com.spring.account.entity.UserEntity;
import com.spring.account.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/account")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/addUser")
    public void addUserDetail(@RequestBody UserEntity user){
       userService.addUser(user);
    }
}
