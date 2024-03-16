package com.example.lab4.jwt;

import lombok.Getter;

public class JwtResponse {
    @Getter
    private final String jwtToken;

    public JwtResponse(String jwtToken) {
        this.jwtToken = jwtToken;
    }
}
