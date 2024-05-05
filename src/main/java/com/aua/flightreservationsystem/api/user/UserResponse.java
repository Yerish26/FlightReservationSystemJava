package com.aua.flightreservationsystem.api.user;

import lombok.Value;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

@Value
@Jacksonized
@SuperBuilder
public class UserResponse {
    String name;
}
