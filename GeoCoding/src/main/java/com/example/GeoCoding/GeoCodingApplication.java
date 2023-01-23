package com.example.GeoCoding;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class GeoCodingApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(GeoCodingApplication.class, args);
	}

}
