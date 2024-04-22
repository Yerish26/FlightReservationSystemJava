package com.aua.flightreservationsystem.core.flight.exceptions;

public class UsernameNotFoundException extends Exception{
    public UsernameNotFoundException(String username){
        super("Username " + username + " not found");
    }
}
