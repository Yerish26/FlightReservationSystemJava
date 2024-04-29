package com.aua.flightreservationsystem.core.jwt;

import com.aua.flightreservationsystem.persistence.model.UserEntity;
import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder(toBuilder = true)
public class Token {
    UUID id;
    String token;
    boolean loggedOut;
    UserEntity user;
}
