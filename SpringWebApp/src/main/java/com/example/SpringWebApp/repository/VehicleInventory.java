package com.example.SpringWebApp.repository;

import com.example.SpringWebApp.service.VehicleCRUDService;
import com.example.SpringWebApp.vehicleinventory.Vehicle;
import com.example.SpringWebApp.vehicleinventory.VehicleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class VehicleInventory {
    private static final Logger logger = LoggerFactory.getLogger(VehicleCRUDService.class);

    public static List<Vehicle> allVehicles=new ArrayList<>();

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
        vehicle1.setId("1");
        allVehicles.add(vehicle1);
        Vehicle vehicle2 = vehicleServiceFactory2.createVehicle();
        vehicle2.setId("2");
        allVehicles.add(vehicle2);
    }
}
