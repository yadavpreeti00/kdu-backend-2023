package com.example.SpringWebApp.vehicleinventory;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public interface VehicleService {
    public Vehicle createVehicle();
}
