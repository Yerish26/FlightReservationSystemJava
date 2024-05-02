package com.aua.flightreservationsystem.core.country.exceptions;

import java.util.UUID;

public class CountryNotFoundException extends Exception {
    public CountryNotFoundException(UUID id) {
        super("Country with id " + id.toString() + " is not found");
    }
}
