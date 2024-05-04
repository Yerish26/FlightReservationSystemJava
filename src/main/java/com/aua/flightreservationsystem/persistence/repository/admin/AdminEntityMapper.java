package com.aua.flightreservationsystem.persistence.repository.admin;

import com.aua.flightreservationsystem.core.admin.Admin;
import com.aua.flightreservationsystem.persistence.model.AdminEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AdminEntityMapper {
    Admin map(AdminEntity adminEntity);

    AdminEntity map(Admin admin);
}
