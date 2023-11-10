package com.spring.account.repository;

import com.spring.account.entity.UserAuthentication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserAuthenticationRepository extends JpaRepository<UserAuthentication,Integer> {

    Optional<UserAuthentication> getUserAuthenticationByUsernameAndAndPassword(@RequestParam String username, @RequestParam String password);

    @Query(value = "select ua.customerId from UserAuthentication ua where ua.username=(:username) and ua.password=(:password)")
    UUID getCustomerIdByUsernameAndAndPassword(@RequestParam String username, @RequestParam String password);
}
