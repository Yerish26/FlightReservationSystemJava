package com.aua.flightreservationsystem.core.airline.exceptions;

import java.util.UUID;

public class AirlineNotFoundException extends Exception {
    public AirlineNotFoundException(UUID id) {
        super("airline with id " + id.toString() + " not found");
    }
}
