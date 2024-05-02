package com.aua.flightreservationsystem.core.customer.exceptions;

import java.util.UUID;

public class CustomerAlreadyExistsException extends Exception{
    public CustomerAlreadyExistsException(UUID id){
        super("The customer with id " + id.toString() + " already exists");
    }
}
