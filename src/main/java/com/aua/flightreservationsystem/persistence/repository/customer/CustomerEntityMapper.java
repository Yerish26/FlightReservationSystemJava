package com.aua.flightreservationsystem.persistence.repository.customer;

import com.aua.flightreservationsystem.core.customer.Customer;
import com.aua.flightreservationsystem.persistence.model.CustomerEntity;
import com.aua.flightreservationsystem.persistence.model.UserEntity;
import com.aua.flightreservationsystem.persistence.repository.user.UserEntityMapper;
import org.springframework.stereotype.Component;

@Component
public class CustomerEntityMapper {
    private final UserEntityMapper userEntityMapper;

    public CustomerEntityMapper(UserEntityMapper userEntityMapper) {
        this.userEntityMapper = userEntityMapper;
    }

    public Customer map(CustomerEntity customerEntity) {
        return Customer.builder()
                .id(customerEntity.getId())
                .registrationDate(customerEntity.getRegistrationDate())
                .user(userEntityMapper.map(customerEntity.getUser()))
                .build();
    }

    public CustomerEntity map(Customer customer) {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setId(customer.getId());
        customerEntity.setRegistrationDate(customer.getRegistrationDate());
        customerEntity.setUser(userEntityMapper.map(customer.getUser()));
        return customerEntity;
    }
}
