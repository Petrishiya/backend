package com.spring.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication(scanBasePackages = "com.spring.backend")
@CrossOrigin(origins = "http://localhost:4200")
public class BackendApplication
{

	public static void main(String[] args)
	{
		SpringApplication.run(BackendApplication.class, args);
		System.out.println("Application running");

	}
}
