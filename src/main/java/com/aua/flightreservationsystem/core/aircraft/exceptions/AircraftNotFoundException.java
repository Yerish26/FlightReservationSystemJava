package com.aua.flightreservationsystem.core.aircraft.exceptions;

import java.util.UUID;

public class AircraftNotFoundException extends Exception {
    public AircraftNotFoundException(UUID id) {
        super("Aircraft with id " + id.toString() + " is not found");
    }
}
