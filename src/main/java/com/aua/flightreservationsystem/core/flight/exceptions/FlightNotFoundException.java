package com.aua.flightreservationsystem.core.flight.exceptions;

public class FlightNotFoundException extends Exception{
    public FlightNotFoundException(Long flightId){
        super("Flight with id " + flightId + " not found");
    }
}
