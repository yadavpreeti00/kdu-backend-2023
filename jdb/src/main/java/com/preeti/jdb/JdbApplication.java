package com.preeti.jdb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.util.UUID;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class JdbApplication {



	public static void main(String[] args) {
		SpringApplication.run(JdbApplication.class, args);

	}

}
