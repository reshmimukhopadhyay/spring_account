package com.spring.account.service;

import com.spring.account.entity.UserEntity;
import com.spring.account.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void addUser(UserEntity user){
        if(user.getName()!=null){
            userRepository.addUser(user);
        }
    }
}
