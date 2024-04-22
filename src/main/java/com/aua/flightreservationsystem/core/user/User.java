package com.aua.flightreservationsystem.core.user;

import com.aua.flightreservationsystem.persistence.model.Role;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class User {
    Long customerId;
    String firstName;
    String lastName;
    String username;
    String password;
    Role role;
}
