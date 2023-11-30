package com.spring.account.service;

import com.spring.account.entity.UserAuthentication;
import com.spring.account.repository.UserAuthenticationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserAuthenticationService {


    UserAuthenticationRepository userAuthenticationRepository;

    @Autowired
    public UserAuthenticationService(UserAuthenticationRepository userAuthenticationRepository){
        this.userAuthenticationRepository=userAuthenticationRepository;
    }

    public UserAuthentication registerUsernameAndPassword(UserAuthentication userAuthentication){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = bCryptPasswordEncoder.encode(userAuthentication.getPassword());
        userAuthentication.setPassword(encodedPassword);
        return userAuthenticationRepository.save(userAuthentication);
    }

     public UUID getUserUUIDByUserNameAndPassword(UserAuthentication userAuthentication) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
         Optional<UserAuthentication> getCustomerUUIDByUsernameAndPassword = userAuthenticationRepository.getUserAuthenticationByUsernameAndAndPassword(userAuthentication.getUsername(), userAuthentication.getPassword());
        if (getCustomerUUIDByUsernameAndPassword.isPresent()) {
            UserAuthentication databasePassword = getCustomerUUIDByUsernameAndPassword.get();
            if (bCryptPasswordEncoder.matches(userAuthentication.getPassword(), databasePassword.getPassword())) {
                UUID customerUUID = userAuthentication.getCustomerId();
                return customerUUID;
            }
        }
        return null;
    }
}
