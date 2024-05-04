package com.aua.flightreservationsystem.persistence.repository.customer;

import com.aua.flightreservationsystem.core.customer.Customer;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerJpaPersistenceManager implements CustomerPersistenceManager {
    private final CustomerRepository customerRepository;
    private final CustomerEntityMapper customerEntityMapper;

    @Autowired
    public CustomerJpaPersistenceManager(
            CustomerRepository customerRepository, CustomerEntityMapper customerEntityMapper) {
        this.customerRepository = customerRepository;
        this.customerEntityMapper = customerEntityMapper;
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll().stream()
                .map(customerEntityMapper::map)
                .toList();
    }

    @Override
    public Optional<Customer> findById(UUID id) {
        return customerRepository.findById(id).map(customerEntityMapper::map);
    }

    @Override
    public Customer save(Customer customer) {
        return customerEntityMapper.map(customerRepository.save(customerEntityMapper.map(customer)));
    }

    @Override
    public void delete(UUID id) {
        customerRepository.deleteById(id);
    }
}
