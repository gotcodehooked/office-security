package com.example.controlpointservice.controllers;

import com.example.controlpointservice.model.EmployeeCardDetail;
import com.example.controlpointservice.service.CheckCardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.net.ssl.SSLException;


@RestController
public class Controller {

    Logger logger = LoggerFactory.getLogger(Controller.class);

    private final CheckCardService checkCardService;

    @Autowired
    public Controller(CheckCardService checkCardService) {
        this.checkCardService = checkCardService;
    }

    @PostMapping(path = "/verification", produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean verification(@RequestBody EmployeeCardDetail employeeCardDetail) throws SSLException {
        logger.info(employeeCardDetail.getFistName());
        logger.info(employeeCardDetail.getUUID());
        logger.info(employeeCardDetail.getUserID());

        return checkCardService.sendToSecurityService(employeeCardDetail);
    }


}
