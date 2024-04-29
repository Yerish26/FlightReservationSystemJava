package com.aua.flightreservationsystem.persistence.repository.employee;

import com.aua.flightreservationsystem.core.employee.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeJpaPersistenceManager implements EmployeePersistenceManager {
    private final EmployeeRepository employeeRepository;
    private final EmployeeEntityMapper employeeEntityMapper;

    @Autowired
    public EmployeeJpaPersistenceManager(EmployeeRepository employeeRepository, EmployeeEntityMapper employeeEntityMapper) {
        this.employeeRepository = employeeRepository;
        this.employeeEntityMapper = employeeEntityMapper;
    }

    @Override
    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll().stream().map(employeeEntityMapper::map).toList();
    }

    @Override
    public Optional<Employee> findById(UUID id) {
        return employeeRepository.findById(id).map(employeeEntityMapper::map);
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeEntityMapper.map(employeeRepository.save(employeeEntityMapper.map(employee)));
    }

    @Override
    public void deleteEmployee(UUID id) {
        employeeRepository.deleteById(id);
    }
}
