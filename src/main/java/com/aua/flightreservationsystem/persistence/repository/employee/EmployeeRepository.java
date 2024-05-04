package com.aua.flightreservationsystem.persistence.repository.employee;

import com.aua.flightreservationsystem.persistence.model.EmployeeEntity;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, UUID> {}
