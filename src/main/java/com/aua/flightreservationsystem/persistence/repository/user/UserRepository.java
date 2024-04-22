package com.aua.flightreservationsystem.persistence.repository.user;

import com.aua.flightreservationsystem.persistence.model.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<CustomerEntity, Long> {
    Optional<CustomerEntity> findByUsername(String username);
}
