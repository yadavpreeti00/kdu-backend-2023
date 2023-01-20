package com.mains;

import com.vehicleinventory.InventoryStore;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Main {

	public static void main(String[] args)
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(ProjectConfig.class);

		InventoryStore inventoryStore=context.getBean(InventoryStore.class);
		inventoryStore.printVehicle();
		inventoryStore.getMostExpensiveVehicle();
	}

}
