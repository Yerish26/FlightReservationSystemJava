package com.aua.flightreservationsystem.core.flight.exceptions;

public class FlightAlreadyExistsException extends Exception{
    public FlightAlreadyExistsException(Long flightId){
        super("The flight with id " + flightId + " already exists");
    }
}
