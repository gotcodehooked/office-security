package com.example.controlpointservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ControlPointServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ControlPointServiceApplication.class, args);

	}

}
