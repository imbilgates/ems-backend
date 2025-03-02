package com.bilgates.employeeCRUD.service;

import com.bilgates.employeeCRUD.dto.EmployeesDto;
import com.bilgates.employeeCRUD.entity.Employee;
import com.bilgates.employeeCRUD.exception.ResourceNotFoundException;
import com.bilgates.employeeCRUD.mapper.EmployeeMapper;
import com.bilgates.employeeCRUD.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService implements EmployeeServiceImp {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeesDto createEmployee(EmployeesDto employeesDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeesDto);
        Employee savedEmployee = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeesDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("Employee Not Exist With Given Id")
        );
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeesDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream()
                .map(EmployeeMapper::mapToEmployeeDto)
                .collect(Collectors.toList());
    }

    @Override
    public EmployeesDto updateEmployee(Long employeeId, EmployeesDto updatedEmployee) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("Employee Not Exist With Given Id")
        );

        employee.setFirstName(updatedEmployee.getFirstName());
        employee.setLastName(updatedEmployee.getLastName());
        employee.setEmail(updatedEmployee.getEmail());

        Employee updatedEmployObj = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(updatedEmployObj);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("Employee Not Exist With Given Id")
        );

        employeeRepository.deleteById(employeeId);
    }

}
