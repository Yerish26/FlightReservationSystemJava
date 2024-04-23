package com.aua.flightreservationsystem.api.user;

import com.aua.flightreservationsystem.persistence.model.Role;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
public class UserRequest {
    String username;
    String password;
    String firstName;
    String lastName;
    Role role;
}
