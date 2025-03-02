package com.bilgates.employeeCRUD.mapper;

import com.bilgates.employeeCRUD.dto.EmployeesDto;
import com.bilgates.employeeCRUD.entity.Employee;

public class EmployeeMapper {
    public static EmployeesDto mapToEmployeeDto(Employee employee){
        return new EmployeesDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail()
        );
    }

    public static Employee mapToEmployee(EmployeesDto employeesDto){
        return new Employee(
                employeesDto.getId(),
                employeesDto.getFirstName(),
                employeesDto.getLastName(),
                employeesDto.getEmail()
        );
    }
}
