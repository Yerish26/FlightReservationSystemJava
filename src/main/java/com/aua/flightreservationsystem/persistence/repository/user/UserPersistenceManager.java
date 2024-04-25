package com.aua.flightreservationsystem.persistence.repository.user;

import com.aua.flightreservationsystem.core.user.User;

import java.util.List;
import java.util.Optional;

public interface UserPersistenceManager {
    List<User> findAllUsers();

    Optional<User> findById(Long id);

    Optional<User> findByUsername(String username);

    User save(User customer);

    void deleteUser(Long customerId); //TODO to be removed in the future
}
