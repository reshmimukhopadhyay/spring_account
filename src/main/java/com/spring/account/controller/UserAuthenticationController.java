package com.spring.account.controller;

import com.spring.account.entity.UserAuthentication;
import com.spring.account.service.UserAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping(value="customer/userAuth")
public class UserAuthenticationController {


    UserAuthenticationService userAuthenticationService;

    @Autowired
    public UserAuthenticationController(UserAuthenticationService userAuthenticationService){
        this.userAuthenticationService=userAuthenticationService;
    }


    @PostMapping("/authentication")
    public ResponseEntity<UserAuthentication> saveUserAuthenticationData(@RequestBody UserAuthentication userAuthentication){
        userAuthenticationService.registerUsernameAndPassword(userAuthentication);
        return new ResponseEntity(HttpStatus.OK);
    }


    @PostMapping("/login")
    public UUID getCustomerId(@RequestBody UserAuthentication userAuthentication){
        return userAuthenticationService.getUserUUIDByUserNameAndPassword(userAuthentication);
    }
}
