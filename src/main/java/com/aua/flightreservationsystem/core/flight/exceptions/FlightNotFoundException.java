package com.aua.flightreservationsystem.core.flight.exceptions;

import java.util.UUID;

public class FlightNotFoundException extends Exception {
    public FlightNotFoundException(UUID id) {
        super("Flight with id " + id.toString() + " is not found");
    }
}
