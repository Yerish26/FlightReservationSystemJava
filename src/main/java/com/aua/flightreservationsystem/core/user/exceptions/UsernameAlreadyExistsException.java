package com.aua.flightreservationsystem.core.user.exceptions;

public class UsernameAlreadyExistsException extends Exception{
    public UsernameAlreadyExistsException(String username){
        super("Username " + username + " already exists");
    }
}
