package com.aua.flightreservationsystem.core.customer;

import lombok.Builder;
import lombok.Value;

import java.util.Date;
import java.util.UUID;

@Value
@Builder(toBuilder = true)
public class Customer {
    UUID id;
    Date registrationDate;
    UUID userId;
}
