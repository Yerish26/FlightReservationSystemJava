package com.aua.flightreservationsystem.core.jwt;

import com.aua.flightreservationsystem.core.user.User;
import java.util.UUID;
import lombok.Builder;
import lombok.Value;

@Value
@Builder(toBuilder = true)
public class Token {
    UUID id;
    String token;
    boolean loggedOut;
    User user;
}
