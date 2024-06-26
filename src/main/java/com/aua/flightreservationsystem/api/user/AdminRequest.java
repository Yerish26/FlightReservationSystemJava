package com.aua.flightreservationsystem.api.user;

import com.aua.flightreservationsystem.persistence.model.RoleInCompany;
import lombok.EqualsAndHashCode;
import lombok.Value;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

@EqualsAndHashCode(callSuper = true)
@Value
@Jacksonized
@SuperBuilder
public class AdminRequest extends UserRequest {
    RoleInCompany roleInCompany;
}
