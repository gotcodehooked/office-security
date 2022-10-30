package com.example.securityservice.controller;


import com.example.securityservice.entity.Employee;
import com.example.securityservice.service.EmployeeSerivice;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    private final EmployeeSerivice employeeSerivice;

    public EmployeeController(EmployeeSerivice employeeSerivice) {
        this.employeeSerivice = employeeSerivice;
    }


    @GetMapping()
    public void getEmployee(@RequestParam Long id){
        System.out.println(id);
        employeeSerivice.findById(id);
    }

    @PostMapping
    public void addEmployee(@RequestBody Employee employee){
        System.out.println(employee);
        employeeSerivice.saveEmployee(employee);
    }
}
