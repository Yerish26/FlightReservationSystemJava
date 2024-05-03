package com.aua.flightreservationsystem.core.aircraftFactory.exceptions;

import java.util.UUID;

public class AircraftFactoryAlreadyExistsException extends Exception {
    public AircraftFactoryAlreadyExistsException(UUID id) {
        super("The aircraft factory with id " + id.toString() + " already exists");
    }
}
