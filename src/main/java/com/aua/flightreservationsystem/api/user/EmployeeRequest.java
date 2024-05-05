package com.aua.flightreservationsystem.api.user;

import java.math.BigDecimal;
import lombok.EqualsAndHashCode;
import lombok.Value;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

@EqualsAndHashCode(callSuper = true)
@Value
@Jacksonized
@SuperBuilder
public class EmployeeRequest extends UserRequest {
    String contact;
    BigDecimal salary;
}
