package com.aua.flightreservationsystem.persistence.repository;

import com.aua.flightreservationsystem.persistence.model.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
    Optional<CustomerEntity> findByUsername(String username);
}
