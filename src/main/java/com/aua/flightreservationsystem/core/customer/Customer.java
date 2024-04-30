package com.aua.flightreservationsystem.core.customer;

import com.aua.flightreservationsystem.core.user.User;
import lombok.Builder;
import lombok.Value;

import java.util.Date;
import java.util.UUID;

@Value
@Builder(toBuilder = true)
public class Customer {
    UUID id;
    Date registrationDate;
    User user;
}
