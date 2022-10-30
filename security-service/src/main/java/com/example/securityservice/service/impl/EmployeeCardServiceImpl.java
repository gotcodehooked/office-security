package com.example.securityservice.service.impl;

import com.example.securityservice.entity.EmployeeCard;
import com.example.securityservice.repository.EmployeeCardRepository;
import com.example.securityservice.service.EmployeeCardService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeCardServiceImpl implements EmployeeCardService {

    private final EmployeeCardRepository employeeCardRepository;

    public EmployeeCardServiceImpl(EmployeeCardRepository employeeCardRepository) {
        this.employeeCardRepository = employeeCardRepository;
    }

    @Override
    public List<EmployeeCard> findAllEmployeeCards() {
        return employeeCardRepository.findAll();
    }

    @Override
    public Optional<EmployeeCard> findById(Long id) {
        return employeeCardRepository.findById(id);
    }


    @Override
    public EmployeeCard saveEmployee(EmployeeCard employeeCard) {
        return employeeCardRepository.save(employeeCard);
    }

    @Override
    public EmployeeCard updateEmployee(EmployeeCard employeeCard) {
        return employeeCardRepository.save(employeeCard);
    }

    @Override
    public void deleteEmployee(Long id) {

    }


}
