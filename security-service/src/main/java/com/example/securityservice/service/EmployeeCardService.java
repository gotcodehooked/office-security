package com.example.securityservice.service;

import com.example.securityservice.entity.Employee;
import com.example.securityservice.entity.EmployeeCard;

import java.util.List;
import java.util.Optional;

public interface EmployeeCardService {

    List<EmployeeCard> findAllEmployeeCards();

    Optional<EmployeeCard> findById(Long id);

    EmployeeCard saveEmployee(EmployeeCard employeeCard);

    EmployeeCard updateEmployee(EmployeeCard employeeCard);

    void deleteEmployee(Long id);

}
