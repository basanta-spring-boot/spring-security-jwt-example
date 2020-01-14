package com.javatechie.spring.jwt.api.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class AuthRequest {
    private String userName;
    private String password;
}
