package com.mains;

import com.speaker.SpeakerService;
import com.tyre.TyreService;
import com.vehicle.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	public static void main(String[] args)
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(VehicleService.class, TyreService.class,SpeakerService.class);
		VehicleService vehicleService=context.getBean(VehicleService.class);

		TyreService tyreService=context.getBean(TyreService.class);

		SpeakerService speakerService=context.getBean(SpeakerService.class);
		vehicleService.printVehicle();
		vehicleService.getMostExpensiveVehicle();
	}

}
