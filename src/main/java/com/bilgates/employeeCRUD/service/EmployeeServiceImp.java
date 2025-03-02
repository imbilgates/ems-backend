package com.bilgates.employeeCRUD.service;

import com.bilgates.employeeCRUD.dto.EmployeesDto;

import java.util.List;

public interface EmployeeServiceImp {
    EmployeesDto createEmployee(EmployeesDto employeesDto);
    EmployeesDto getEmployeeById(Long employeeId);
    List<EmployeesDto> getAllEmployees();
    EmployeesDto updateEmployee(Long employeeId, EmployeesDto updatedEmployee);
    void deleteEmployee(Long employeeId);
}
