package com.aua.flightreservationsystem.core.city.exceptions;

import java.util.UUID;

public class CityNotFoundException extends Exception {
    public CityNotFoundException(UUID id) {
        super("City with id " + id.toString() + " is not found");
    }
}
