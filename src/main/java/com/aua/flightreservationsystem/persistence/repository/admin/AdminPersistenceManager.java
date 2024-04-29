package com.aua.flightreservationsystem.persistence.repository.admin;

import com.aua.flightreservationsystem.core.admin.Admin;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AdminPersistenceManager {
    List<Admin> findAllAdmins();
    Optional<Admin> findById(UUID id);
    Admin saveAdmin(Admin admin);
    void deleteAdmin(UUID id);

}
