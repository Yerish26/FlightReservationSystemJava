package com.aua.flightreservationsystem.core.user;

import java.util.List;
import java.util.Optional;

public interface UserPersistenceManager {
    List<User> findAllCustomers();

    Optional<User> findById(Long id);

    User saveCustomer(User customer);

    void deleteCustomer(Long customerId);
}
