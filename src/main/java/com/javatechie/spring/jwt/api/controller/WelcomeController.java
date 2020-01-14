package com.javatechie.spring.jwt.api.controller;

import com.javatechie.spring.jwt.api.commons.AuthRequest;
import com.javatechie.spring.jwt.api.commons.AuthResponse;
import com.javatechie.spring.jwt.api.entity.User;
import com.javatechie.spring.jwt.api.repository.UserRepository;
import com.javatechie.spring.jwt.api.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository repository;
    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping("/")
    public String hello() {
        return "Welcome to javatechie spring security with jwt tutorial !!";
    }

    @PostMapping("/authenticate")
    public String authenticateUser(@RequestBody AuthRequest authRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            throw new Exception("Bad Credential", e);
        }
        return jwtUtil.generateToken(authRequest.getUserName());
    }
}
