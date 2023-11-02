package com.spring.account.repository;

import com.spring.account.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

   @Query(value="select u.userId from User u where u.username=(:username) and u.password=(:password)" )
   UUID getUserUUIDByNameAndPassword(@RequestParam String username,@RequestParam String password);
}
