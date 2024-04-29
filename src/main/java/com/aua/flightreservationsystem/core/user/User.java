package com.aua.flightreservationsystem.core.user;

import com.aua.flightreservationsystem.persistence.model.Role;
import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder(toBuilder = true)
public class User {
    UUID id;
    String firstName;
    String lastName;
    String username;
    String password;
    Role role;
}
