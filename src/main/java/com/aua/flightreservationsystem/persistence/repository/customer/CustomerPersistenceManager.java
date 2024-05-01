package com.aua.flightreservationsystem.persistence.repository.customer;

import com.aua.flightreservationsystem.core.customer.Customer;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CustomerPersistenceManager {
    List<Customer> findAllCustomers();
    Optional<Customer> findById(UUID id);
    Customer saveCustomer(Customer customer);
    void deleteCustomer(UUID id);
}
