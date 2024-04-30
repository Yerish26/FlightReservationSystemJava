package com.aua.flightreservationsystem.persistence.repository.customer;

import com.aua.flightreservationsystem.core.customer.Customer;
import com.aua.flightreservationsystem.persistence.model.CustomerEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerEntityMapper {
    Customer map(CustomerEntity customerEntity);
    CustomerEntity map(Customer customer);
}
