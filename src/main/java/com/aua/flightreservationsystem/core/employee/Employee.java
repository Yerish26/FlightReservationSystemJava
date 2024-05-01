package com.aua.flightreservationsystem.core.employee;

import com.aua.flightreservationsystem.core.user.User;
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
    User user;
}
