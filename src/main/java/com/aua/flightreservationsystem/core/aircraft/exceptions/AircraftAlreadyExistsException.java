package com.aua.flightreservationsystem.core.aircraft.exceptions;

import java.util.UUID;

public class AircraftAlreadyExistsException extends Exception{
    public AircraftAlreadyExistsException(UUID id){
        super("The aircraft with id " + id.toString() + " already exists");
    }
}
