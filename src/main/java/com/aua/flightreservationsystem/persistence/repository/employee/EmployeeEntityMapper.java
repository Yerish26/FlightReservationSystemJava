package com.aua.flightreservationsystem.persistence.repository.employee;

import com.aua.flightreservationsystem.core.employee.Employee;
import com.aua.flightreservationsystem.persistence.model.EmployeeEntity;
import com.aua.flightreservationsystem.persistence.model.UserEntity;
import com.aua.flightreservationsystem.persistence.repository.user.UserEntityMapper;
import org.springframework.stereotype.Component;

@Component
public class EmployeeEntityMapper {
    private final UserEntityMapper userEntityMapper;

    public EmployeeEntityMapper(UserEntityMapper userEntityMapper) {
        this.userEntityMapper = userEntityMapper;
    }

    public Employee map(EmployeeEntity employeeEntity) {
        return Employee.builder()
                .id(employeeEntity.getId())
                .salary(employeeEntity.getSalary())
                .contact(employeeEntity.getContact())
                .user(userEntityMapper.map(employeeEntity.getUser()))
                .build();
    }

    public EmployeeEntity map(Employee employee) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setId(employee.getId());
        employeeEntity.setSalary(employee.getSalary());
        employeeEntity.setContact(employee.getContact());
        employeeEntity.setUser(userEntityMapper.map(employee.getUser()));
        return employeeEntity;
    }
}