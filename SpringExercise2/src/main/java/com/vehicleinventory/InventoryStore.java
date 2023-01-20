package com.vehicleinventory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Component
public class InventoryStore {

    private static final Logger logger = LoggerFactory.getLogger(InventoryStore.class);

    public List<Vehicle> allVehicles=new ArrayList<>();

    @Autowired
    @Qualifier("factory1")
    private VehicleService vehicleServiceFactory1;
    @Autowired
    @Qualifier("factory2")
    private VehicleService vehicleServiceFactory2;

    @PostConstruct
    public void addVehicles()
    {
        Vehicle vehicle1 = vehicleServiceFactory1.createVehicle();
        allVehicles.add(vehicle1);
        Vehicle vehicle2 = vehicleServiceFactory2.createVehicle();
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
