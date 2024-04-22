package com.aua.flightreservationsystem.persistence.repository;

import com.aua.flightreservationsystem.core.flight.Customer;
import com.aua.flightreservationsystem.persistence.model.CustomerEntity;
import org.springframework.stereotype.Component;

@Component
public class CustomerEntityMapper {
    public Customer map(CustomerEntity customerEntity) {
        return Customer.builder()
                .customerId(customerEntity.getCustomerId())
                .firstName(customerEntity.getFirstName())
                .lastName(customerEntity.getLastName())
                .username(customerEntity.getUsername())
                .password(customerEntity.getPassword())
                .role(customerEntity.getRole())
                .build();
    }

    public CustomerEntity map(Customer customer) {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setCustomerId(customer.getCustomerId());
        customerEntity.setFirstName(customer.getFirstName());
        customerEntity.setLastName(customer.getLastName());
        customerEntity.setUsername(customer.getUsername());
        customerEntity.setPassword(customer.getPassword());
        customerEntity.setRole(customer.getRole());
        return customerEntity;
    }
}
