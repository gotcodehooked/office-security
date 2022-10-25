package com.example.notificationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class NotificationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotificationServiceApplication.class, args);
		RestTemplate restTemplate = new RestTemplate();
		String fooResourceUrl
				= "http://localhost:8765/control-point-service";

		while (true) {

			ResponseEntity<String> response
					= restTemplate.getForEntity(fooResourceUrl + "/hello", String.class);
			System.out.println(response.getStatusCode());
		}
	}


	@GetMapping
	public String hello(){
		return "CONTROL POINT SERVICE";
	}
}
