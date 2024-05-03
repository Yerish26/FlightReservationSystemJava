package com.aua.flightreservationsystem.core.airport.exceptions;

import java.util.UUID;

public class AirportNotFoundException extends Exception {
    public AirportNotFoundException(UUID id) {
        super("Airport with id " + id.toString() + " is not found");
    }
}
