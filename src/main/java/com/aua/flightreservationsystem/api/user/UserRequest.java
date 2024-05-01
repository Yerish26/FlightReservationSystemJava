package com.aua.flightreservationsystem.api.user;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
public abstract class UserRequest {
    protected String username;
    protected String password;
    protected String firstName;
    protected String lastName;
}
