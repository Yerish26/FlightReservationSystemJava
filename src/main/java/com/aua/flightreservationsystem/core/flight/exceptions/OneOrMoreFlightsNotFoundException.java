package com.aua.flightreservationsystem.core.flight.exceptions;

public class OneOrMoreFlightsNotFoundException extends Exception {
    public OneOrMoreFlightsNotFoundException(String message) {
        super(message);
    }
}
