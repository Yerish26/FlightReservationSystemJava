package com.aua.flightreservationsystem.core.employee.exceptions;

import java.util.UUID;

public class EmployeeFlightNotFoundException extends Exception {
    public EmployeeFlightNotFoundException(UUID id) {
        super("Employee with id " + id.toString() + " is not found");
    }
}
