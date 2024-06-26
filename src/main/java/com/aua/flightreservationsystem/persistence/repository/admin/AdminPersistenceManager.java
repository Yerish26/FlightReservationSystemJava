package com.aua.flightreservationsystem.persistence.repository.admin;

import com.aua.flightreservationsystem.core.admin.Admin;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AdminPersistenceManager {
    List<Admin> findAll();

    Optional<Admin> findById(UUID id);

    Admin save(Admin admin);

    void delete(UUID id);
}
