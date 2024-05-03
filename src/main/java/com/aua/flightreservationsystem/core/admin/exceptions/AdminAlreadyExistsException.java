package com.aua.flightreservationsystem.core.admin.exceptions;

import java.util.UUID;

public class AdminAlreadyExistsException extends Exception {
    public AdminAlreadyExistsException(UUID id) {
        super("The admin with id " + id.toString() + " already exists");
    }
}
