package com.spring.account.controller;

import com.spring.account.entity.UserAuthentication;
import com.spring.account.service.UserAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value="customer/userAuth")
public class UserAuthenticationController {

    @Autowired
    UserAuthenticationService userAuthenticationService;


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
