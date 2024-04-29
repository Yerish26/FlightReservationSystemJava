package com.aua.flightreservationsystem.persistence.repository.customer;

import com.aua.flightreservationsystem.core.customer.Customer;
import com.aua.flightreservationsystem.persistence.model.CustomerEntity;
import com.aua.flightreservationsystem.persistence.model.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class CustomerEntityMapper {
    public Customer map(CustomerEntity customerEntity) {
        return Customer.builder()
                .id(customerEntity.getId())
                .registrationDate(customerEntity.getRegistrationDate())
                .userId(customerEntity.getUser().getId())
                .build();
    }

    public CustomerEntity map(Customer customer) {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setId(customer.getId());
        customerEntity.setRegistrationDate(customer.getRegistrationDate());

        UserEntity userEntity = new UserEntity();
        userEntity.setId(customer.getUserId());
        customerEntity.setUser(userEntity);

        return customerEntity;
    }
}
