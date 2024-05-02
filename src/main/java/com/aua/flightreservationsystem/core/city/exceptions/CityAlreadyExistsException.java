package com.aua.flightreservationsystem.core.city.exceptions;

import java.util.UUID;

public class CityAlreadyExistsException extends Exception{
    public CityAlreadyExistsException(UUID id){
        super("The city with id " + id.toString() + " already exists");
    }
}
