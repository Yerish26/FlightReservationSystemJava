package com.aua.flightreservationsystem.core.flight;

import com.aua.flightreservationsystem.persistence.model.Role;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Customer {
    Long customerId;
    String firstName;
    String lastName;
    String username;
    String password;
    Role role;
}
