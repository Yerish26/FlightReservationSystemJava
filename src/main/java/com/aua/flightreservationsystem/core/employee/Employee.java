package com.aua.flightreservationsystem.core.employee;

import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;
import java.util.UUID;

@Value
@Builder(toBuilder = true)
public class Employee {
    UUID id;
    BigDecimal salary;
    String contact;
    UUID userId;
}
