package com.aua.flightreservationsystem.api.user;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
public class UserRequest {
    String username;
    String password;

}
