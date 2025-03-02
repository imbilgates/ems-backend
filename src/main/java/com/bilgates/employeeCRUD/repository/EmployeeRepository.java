package com.bilgates.employeeCRUD.repository;

import com.bilgates.employeeCRUD.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
