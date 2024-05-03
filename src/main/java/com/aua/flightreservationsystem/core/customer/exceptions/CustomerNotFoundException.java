package com.aua.flightreservationsystem.core.customer.exceptions;

import java.util.UUID;

public class CustomerNotFoundException extends Exception {
    public CustomerNotFoundException(UUID id) {
        super("Customer with id " + id.toString() + " is not found");
    }
}
