package com.aua.flightreservationsystem.core.customer;

import com.aua.flightreservationsystem.core.user.User;
import java.util.UUID;
import lombok.Builder;
import lombok.Value;

@Value
@Builder(toBuilder = true)
public class Customer {
    UUID id;
    User user;
}
