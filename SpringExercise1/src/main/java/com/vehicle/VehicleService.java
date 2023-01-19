package com.vehicle;

import com.speaker.SpeakerService;
import com.tyre.TyreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Configuration
@Component
public class VehicleService {

    private static final Logger logger = LoggerFactory.getLogger(VehicleService.class);

    public List<Vehicle> allVehicles=new ArrayList<>();

    @Autowired
    private TyreService tyreService;
    @Autowired
    private SpeakerService speakerService;

    @PostConstruct
    public void addVehicles()
    {
        Vehicle vehicle1=new Vehicle(tyreService.getTyre("MRF"), speakerService.getSpeaker("Bosh"));
        Vehicle vehicle2=new Vehicle(tyreService.getTyre("Bridgestone"), speakerService.getSpeaker("Sony"));
        allVehicles.add(vehicle1);
        allVehicles.add(vehicle2);
    }

    public void printVehicle()
    {
        logger.info("All Vehicles are:");
        for(Vehicle vehicle:allVehicles)
        {
            logger.info(vehicle.toString().toString());
        }
    }
    public void getMostExpensiveVehicle()
    {
        logger.info("The Most Expensive Vehicle is :");
        Vehicle mostExpensive = allVehicles.stream()
                .max(Comparator.comparingDouble(Vehicle::getTotalPrice))
                .orElse(null);
        logger.info(mostExpensive.toString().toString());
    }


}
