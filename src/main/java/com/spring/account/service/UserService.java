package com.spring.account.service;

import com.spring.account.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public UUID getUserUUIDByUserNameAndPassword(String username,String password){
        UUID userUUID=userRepository.getUserUUIDByNameAndPassword(username,password);
        return userUUID;
    }
}
