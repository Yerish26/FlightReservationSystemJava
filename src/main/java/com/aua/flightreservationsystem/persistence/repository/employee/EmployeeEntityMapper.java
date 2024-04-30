package com.aua.flightreservationsystem.persistence.repository.employee;

import com.aua.flightreservationsystem.core.employee.Employee;
import com.aua.flightreservationsystem.persistence.model.EmployeeEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeEntityMapper {
    Employee map(EmployeeEntity employeeEntity);
    EmployeeEntity map(Employee employee);
}