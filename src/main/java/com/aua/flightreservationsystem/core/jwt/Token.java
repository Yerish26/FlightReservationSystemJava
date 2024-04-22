package com.aua.flightreservationsystem.core.jwt;

import com.aua.flightreservationsystem.persistence.model.UserEntity;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Token {
    Long tokenId;
    String token;
    boolean loggedOut;
    UserEntity customer;
}