package com.aua.flightreservationsystem.persistence.repository.user;

import com.aua.flightreservationsystem.core.user.User;
import com.aua.flightreservationsystem.persistence.model.CustomerEntity;
import org.springframework.stereotype.Component;

@Component
public class UserEntityMapper {
    public User map(CustomerEntity customerEntity) {
        return User.builder()
                .customerId(customerEntity.getCustomerId())
                .firstName(customerEntity.getFirstName())
                .lastName(customerEntity.getLastName())
                .username(customerEntity.getUsername())
                .password(customerEntity.getPassword())
                .role(customerEntity.getRole())
                .build();
    }

    public CustomerEntity map(User customer) {
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
