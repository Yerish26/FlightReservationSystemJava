package com.aua.flightreservationsystem.core.admin;

import com.aua.flightreservationsystem.core.user.User;
import com.aua.flightreservationsystem.persistence.model.RoleInCompany;
import java.util.UUID;
import lombok.Builder;
import lombok.Value;

@Value
@Builder(toBuilder = true)
public class Admin {
    UUID id;
    RoleInCompany roleInCompany;
    User user;
}
