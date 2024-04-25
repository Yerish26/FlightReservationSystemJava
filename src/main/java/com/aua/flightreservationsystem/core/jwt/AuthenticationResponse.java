package com.aua.flightreservationsystem.core.jwt;

import lombok.Data;

@Data
public class AuthenticationResponse {
    private String token;
    private String message;

    public AuthenticationResponse(String token, String message) {
        this.token = token;
        this.message = message;
    }
}