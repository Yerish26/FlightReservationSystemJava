package com.aua.flightreservationsystem.core.employee.exceptions;

import java.util.UUID;

public class EmployeeAlreadyExistsException extends Exception{
    public EmployeeAlreadyExistsException(UUID id){
        super("The employee with id " + id.toString() + " already exists");
    }
}
