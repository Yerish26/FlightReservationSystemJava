package com.aua.flightreservationsystem.core.airport.exceptions;

import java.util.UUID;

public class AirportAlreadyExistsException extends Exception {
    public AirportAlreadyExistsException(UUID id) {
        super("The airport with id " + id.toString() + " already exists");
    }
}
