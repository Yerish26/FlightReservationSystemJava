package com.aua.flightreservationsystem.persistence.repository;

import com.aua.flightreservationsystem.core.flight.Customer;
import com.aua.flightreservationsystem.core.flight.CustomerPersistenceManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerJpaPersistenceManager implements CustomerPersistenceManager {
    private final CustomerRepository customerRepository;

    private final CustomerEntityMapper customerEntityMapper;

    @Autowired
    public CustomerJpaPersistenceManager(CustomerRepository customerRepository, CustomerEntityMapper customerEntityMapper) {
        this.customerRepository = customerRepository;
        this.customerEntityMapper = customerEntityMapper;
    }


    @Override
    public List<Customer> findAllCustomers() {
        return customerRepository.findAll().stream().map(customerEntityMapper::map).toList();
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return customerRepository.findById(id).map(customerEntityMapper::map);
    }


    @Override
    public Customer saveCustomer(Customer customer) {
        return customerEntityMapper.map(customerRepository.save(customerEntityMapper.map(customer)));
    }

    @Override
    public void deleteCustomer(Long customerId) {
        customerRepository.deleteById(customerId);
    }
}
