package com.example.securityservice.controller;


import com.example.securityservice.entity.EmployeeCard;
import com.example.securityservice.service.EmployeeCardService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/employee_card")
public class EmployeeCardController {

    private final EmployeeCardService eployeeCardSevice;


    public EmployeeCardController(EmployeeCardService employeeCardService) {
        this.eployeeCardSevice = employeeCardService;
    }

    @PostMapping
    public void createCard(@RequestBody EmployeeCard employeeCard) {


    }


    @GetMapping("/card/")
    public void getCardById(@RequestParam Long id) {
        System.out.println(id);
        Optional<EmployeeCard> employeeCard = eployeeCardSevice.findById(id);
        System.out.println(employeeCard.isPresent());

    }


    @GetMapping()
    public List<EmployeeCard> getAllCards() {


//      Optional<EmployeeCard> employeeCard =  eployeeCardSevice.findById(id);
//
//        if (employeeCard.isPresent()){
//            System.out.println("sfsdfsdf");
//        }else System.out.println(employeeCard.get());
        return eployeeCardSevice.findAllEmployeeCards();
    }
}
