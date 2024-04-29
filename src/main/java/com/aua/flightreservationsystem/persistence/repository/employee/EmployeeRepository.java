package com.aua.flightreservationsystem.persistence.repository.employee;

import com.aua.flightreservationsystem.persistence.model.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, UUID> {
}
