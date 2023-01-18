package com.mains;

import com.config.AppConfig;
import com.example.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {


	public static void main(String[] args)
	{

		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class, VehicleService.class);

		//use of @Beans
		TyreService tyreBridgestone=context.getBean("tyre1",TyreService.class);
		TyreService tyreMRF=context.getBean("tyre2",TyreService.class);

		//use of @Component
		SonySpeaker speakerSony=context.getBean(SonySpeaker.class);
		speakerSony.setSpeakerBrand("Sony");
		speakerSony.setSpeakerPrice(200.0);

		BoshSpeaker speakerBose=context.getBean(BoshSpeaker.class);
		speakerBose.setSpeakerBrand("Bose");
		speakerBose.setSpeakerPrice(400.0);

		Vehicle vehicle1=new Vehicle(tyreBridgestone,speakerSony);
		Vehicle vehicle2=new Vehicle(tyreMRF,speakerBose);
		VehicleService obj=new VehicleService(vehicle1,vehicle2);

		obj.printVehicle();
		obj.getMostExpensiveVehicle();
	}

}
