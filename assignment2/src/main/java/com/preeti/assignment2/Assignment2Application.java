package com.preeti.assignment2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class Assignment2Application {

	public static void main(String[] args)
	{
		SpringApplication.run(Assignment2Application.class, args);
	}

}
