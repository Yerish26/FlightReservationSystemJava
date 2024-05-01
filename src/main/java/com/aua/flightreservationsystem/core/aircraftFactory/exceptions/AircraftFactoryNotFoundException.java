package com.aua.flightreservationsystem.core.aircraftFactory.exceptions;

import java.util.UUID;

public class AircraftFactoryNotFoundException extends Exception{
    public AircraftFactoryNotFoundException(UUID id) {
        super("Aircraft Factory with id " + id.toString() + " is not found");
    }
}
