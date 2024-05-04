package com.aua.flightreservationsystem.persistence.repository.customer;

import com.aua.flightreservationsystem.persistence.model.CustomerEntity;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerEntity, UUID> {}
