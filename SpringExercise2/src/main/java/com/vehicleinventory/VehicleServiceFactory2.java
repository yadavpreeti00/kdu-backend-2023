package com.vehicleinventory;

import com.speaker.SpeakerService;
import com.tyre.TyreService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Data
@Component
@Qualifier("factory2")
public class VehicleServiceFactory2 implements VehicleService{

    @Autowired
    private TyreService tyreService;
    @Autowired
    private SpeakerService speakerService;
    @Override
    public Vehicle createVehicle()
    {
        Vehicle vehicle=new Vehicle(tyreService.getTyre("Bridgestone"), speakerService.getSpeaker("Sony"));
        return vehicle;
    }
}
