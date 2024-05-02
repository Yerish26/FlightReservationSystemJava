package com.aua.flightreservationsystem.core.user.exceptions;

public class UsernameNotFoundException extends Exception{
    public UsernameNotFoundException(String username){
        super("Username " + username + " is not found");
    }
}
