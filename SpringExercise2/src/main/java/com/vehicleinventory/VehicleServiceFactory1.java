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
@Qualifier("factory1")
public class VehicleServiceFactory1 implements VehicleService{

    @Autowired
    private TyreService tyreService;
    @Autowired
    private SpeakerService speakerService;
    @Override
    public Vehicle createVehicle()
    {
        Vehicle vehicle=new Vehicle(tyreService.getTyre("MRF"), speakerService.getSpeaker("Bosh"));
        vehicle.getSpeaker().setPrice(vehicle.getSpeaker().getPrice()+vehicle.getSpeaker().getPrice()*0.1);
        return vehicle;
    }

}
