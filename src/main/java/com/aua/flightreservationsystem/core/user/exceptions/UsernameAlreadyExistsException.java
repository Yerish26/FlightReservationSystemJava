package com.aua.flightreservationsystem.core.user.exceptions;

public class UsernameAlreadyExistsException extends Exception {
    public UsernameAlreadyExistsException(String username) {
        super("The username " + username + " already exists");
    }
}
