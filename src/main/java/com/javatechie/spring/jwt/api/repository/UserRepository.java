package com.javatechie.spring.jwt.api.repository;

import com.javatechie.spring.jwt.api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByUserName(String userName);
}
