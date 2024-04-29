package com.aua.flightreservationsystem.persistence.repository.employee;

import com.aua.flightreservationsystem.core.employee.Employee;
import com.aua.flightreservationsystem.persistence.model.EmployeeEntity;
import com.aua.flightreservationsystem.persistence.model.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class EmployeeEntityMapper {
    public Employee map(EmployeeEntity employeeEntity) {
        return Employee.builder()
                .id(employeeEntity.getId())
                .salary(employeeEntity.getSalary())
                .contact(employeeEntity.getContact())
                .userId(employeeEntity.getUser().getId())
                .build();
    }
    public EmployeeEntity map(Employee employee) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setId(employee.getId());
        employeeEntity.setSalary(employee.getSalary());
        employeeEntity.setContact(employee.getContact());

        UserEntity userEntity = new UserEntity();
        userEntity.setId(employee.getUserId());
        employeeEntity.setUser(userEntity);

        return employeeEntity;
    }

}