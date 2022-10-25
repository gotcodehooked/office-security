package com.example.securityservice.service;

import com.example.securityservice.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeSerivice {
    List<Employee> findAllEmployee();

    Optional<Employee> findById(Long id);

    Employee saveEmployee(Employee employee);

    Employee updateEmployee(Employee employee);

    void deleteEmployee(Long id);
}
