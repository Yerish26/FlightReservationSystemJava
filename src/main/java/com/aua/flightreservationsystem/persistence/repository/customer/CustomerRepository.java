package com.aua.flightreservationsystem.persistence.repository.customer;

import com.aua.flightreservationsystem.persistence.model.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CustomerRepository extends JpaRepository<CustomerEntity, UUID> {
}
