package com.aua.flightreservationsystem.core.admin;

import com.aua.flightreservationsystem.persistence.model.RoleInCompany;
import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder(toBuilder = true)
public class Admin {
    UUID id;
    RoleInCompany roleInCompany;
    UUID userId;
}
