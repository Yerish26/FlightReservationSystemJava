package com.aua.flightreservationsystem.core.flight;

import com.aua.flightreservationsystem.persistence.model.CustomerEntity;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Token {
    Long tokenId;
    String token;
    boolean loggedOut;
    CustomerEntity customer;

}
