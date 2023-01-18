package com.example;

import com.mains.Main;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class VehicleService {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    List<Vehicle> allVehicles=new ArrayList<>();

    public VehicleService(){

    }
    private Vehicle vehicle1;
    private Vehicle vehicle2;

    public VehicleService(Vehicle vehicle1,Vehicle vehicle2){
        this.vehicle1=vehicle1;
        this.vehicle2=vehicle2;
        allVehicles.add(vehicle1);
        allVehicles.add(vehicle2);
    }

    @PostConstruct
    public void addVehicles()
    {
        this.allVehicles=allVehicles;
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
        if(mostExpensive.getBoshSpeaker().equals(null))
        {
            logger.info(mostExpensive.getSonySpeaker().toString());
        }
        else
        {
            logger.info(mostExpensive.getBoshSpeaker().toString());
        }
    }
}
