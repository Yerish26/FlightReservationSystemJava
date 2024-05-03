package com.aua.flightreservationsystem.core.country.exceptions;

import java.util.UUID;

public class CountryAlreadyExistsException extends Exception {
    public CountryAlreadyExistsException(UUID id) {
        super("The country with id " + id.toString() + " already exists");
    }
}
