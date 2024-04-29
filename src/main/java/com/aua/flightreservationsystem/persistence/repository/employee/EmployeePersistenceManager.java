package com.aua.flightreservationsystem.persistence.repository.employee;

import com.aua.flightreservationsystem.core.employee.Employee;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EmployeePersistenceManager {
    List<Employee> findAllEmployees();
    Optional<Employee> findById(UUID id);
    Employee saveEmployee(Employee employee);
    void deleteEmployee(UUID id);
}
