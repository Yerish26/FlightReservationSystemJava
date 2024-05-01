package com.aua.flightreservationsystem.core.airline.exceptions;

import java.util.UUID;

public class AirlineAlreadyExistsException extends Exception{
    public AirlineAlreadyExistsException(UUID id){
        super("The airline with id " + id.toString() + " already exists");
    }
}
