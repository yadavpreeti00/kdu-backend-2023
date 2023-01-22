package com.example.SpringWebApp.service;

import com.example.SpringWebApp.vehicleinventory.Vehicle;
import com.example.SpringWebApp.vehicleinventory.VehicleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static com.example.SpringWebApp.repository.VehicleInventory.allVehicles;


@Component
public class VehicleCRUDService {


        private static final Logger logger = LoggerFactory.getLogger(VehicleCRUDService.class);

        public Vehicle getVehicle(String id) {

            String compId;
            Vehicle vehicle=null;
            for(Vehicle veh: allVehicles)
            {
                compId=veh.getId();
                if(compId.equals(id))
                {
                     vehicle=veh;
                     break;
                }
            }
            return vehicle;
        }

        public void createVehicle(Vehicle vehicle)
        {
            allVehicles.add(vehicle);
        }
        public Vehicle updateVehicle(String id, Vehicle updatedVehicle) {
            for (Vehicle vehicle : allVehicles) {
                if (vehicle.getId().equals(id)) {
                    vehicle.setTyre(updatedVehicle.getTyre());
                    vehicle.setSpeaker(updatedVehicle.getSpeaker());
                    vehicle.setTotalPrice(updatedVehicle.getTotalPrice());
                    return vehicle;
                }
            }
            throw new RuntimeException("Vehicle not found: " + id);
        }
        public void deleteVehicle(String id) {

            String compId;
            Vehicle vehicle=null;
            for(Vehicle veh: allVehicles)
            {
                compId=veh.getId();
                if(compId.equals(id))
                {
                    vehicle=veh;
                    allVehicles.remove(veh);
                    break;
                }
            }

        }

        public Vehicle getMostExpensiveVehicle(String order)
        {

            Vehicle vehicle=null;
            if(order.equals("most"))
            {
                logger.info("The Most Expensive Vehicle is :");
                 vehicle= allVehicles.stream()
                        .max(Comparator.comparingDouble(Vehicle::getTotalPrice))
                        .orElse(null);
            }
            else if(order.equals("least"))
            {
                logger.info("The Least Expensive Vehicle is :");
                vehicle= allVehicles.stream()
                        .min(Comparator.comparingDouble(Vehicle::getTotalPrice))
                        .orElse(null);
            }
            logger.info(vehicle.toString());
            return vehicle;
        }

        public void printVehicle()
        {
            logger.info("All Vehicles are:");
            for(Vehicle vehicle:allVehicles)
            {
                logger.info(vehicle.toString().toString());
            }
        }


}
