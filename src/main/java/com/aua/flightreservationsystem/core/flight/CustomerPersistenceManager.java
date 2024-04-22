package com.aua.flightreservationsystem.core.flight;

import java.util.List;
import java.util.Optional;

public interface CustomerPersistenceManager {
    List<Customer> findAllCustomers();

    Optional<Customer> findById(Long id);

    Customer saveCustomer(Customer customer);

    void deleteCustomer(Long customerId);
}
