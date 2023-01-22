package com.example.SpringWebApp;

import com.example.SpringWebApp.repository.VehicleInventory;
import com.example.SpringWebApp.service.VehicleCRUDService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class SpringWebAppApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(SpringWebAppApplication.class, args);
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(ProjectConfig.class);
		VehicleInventory vehicleInventory=context.getBean(VehicleInventory.class);
		VehicleCRUDService vehicleCRUDService=context.getBean(VehicleCRUDService.class);
		vehicleCRUDService.printVehicle();
		vehicleCRUDService.getMostExpensiveVehicle("most");
		vehicleCRUDService.getMostExpensiveVehicle("least");
	}
}
