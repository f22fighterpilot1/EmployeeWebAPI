package com.example.employeewebapi;

import com.example.employeewebapi.controller.EmployeeController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class EmployeeWebApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeWebApiApplication.class, args);
	}

}
