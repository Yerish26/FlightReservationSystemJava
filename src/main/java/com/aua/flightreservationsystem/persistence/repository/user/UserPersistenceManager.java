package com.aua.flightreservationsystem.persistence.repository.user;

import com.aua.flightreservationsystem.core.user.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserPersistenceManager {
    List<User> findAllUsers();

    Optional<User> findById(UUID id);

    Optional<User> findByUsername(String username);

    User save(User customer);

    void deleteUser(UUID id); //TODO to be removed in the future
}
