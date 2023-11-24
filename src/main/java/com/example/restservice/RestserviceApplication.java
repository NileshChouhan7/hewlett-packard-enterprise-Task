package com.example.restservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.example.restservice") 
public class RestserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestserviceApplication.class, args);
	}

}
