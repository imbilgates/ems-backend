package com.bilgates.employeeCRUD.controller;

import com.bilgates.employeeCRUD.dto.EmployeesDto;
import com.bilgates.employeeCRUD.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeesController {

    @Autowired
    private EmployeeService employeeService;


    @PostMapping
    public ResponseEntity<EmployeesDto> createEmployee(@RequestBody EmployeesDto employeesDto){
        EmployeesDto savedEmployee = employeeService.createEmployee(employeesDto);

        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<EmployeesDto> employeeGetById(@PathVariable("id") Long employeeId){
        EmployeesDto employeesDto = employeeService.getEmployeeById(employeeId);
        return ResponseEntity.ok(employeesDto);
    }

    @GetMapping()
    public ResponseEntity<List<EmployeesDto>> getAllEmployees(){
        List<EmployeesDto> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    @PutMapping("{id}")
    public ResponseEntity<EmployeesDto> updateEmployee(@PathVariable("id") Long employeeId,@RequestBody EmployeesDto updatedEmployee){
        EmployeesDto employeeDto = employeeService.updateEmployee(employeeId, updatedEmployee);
        return ResponseEntity.ok(employeeDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteByEmployeeId(@PathVariable("id") Long employeeId){
        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.ok("Employee Deleted Successfully..");
    }
}
