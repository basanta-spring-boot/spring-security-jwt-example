package com.javatechie.spring.jwt.api.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;


@Data
@ToString
@AllArgsConstructor
public class AuthResponse {

    private final String jsonWebToken;
}
