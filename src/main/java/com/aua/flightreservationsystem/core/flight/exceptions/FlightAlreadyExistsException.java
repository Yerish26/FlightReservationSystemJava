package com.aua.flightreservationsystem.core.flight.exceptions;

import java.util.UUID;

public class FlightAlreadyExistsException extends Exception {
    public FlightAlreadyExistsException(UUID id) {
        super("The flight with id " + id.toString() + " already exists");
    }
}
