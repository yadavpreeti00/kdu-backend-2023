package com.example.SpringWebApp.vehicleinventory;


import com.example.SpringWebApp.speaker.Speaker;
import com.example.SpringWebApp.tyre.Tyre;
import lombok.Data;
import org.springframework.boot.convert.DataSizeUnit;
import org.springframework.lang.NonNull;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class Vehicle {

    @NotBlank(message = "Vehicle Id shpould not be blank")
    @Size(min=1,message ="Size of Id should be at least 1")
    private String id;

    private Tyre tyre;
    private Speaker speaker;
    private Double totalPrice;

    public Vehicle(Tyre tyre,Speaker speaker)
    {
        this.id=id;
        this.speaker=speaker;
        this.tyre=tyre;
        this.totalPrice= speaker.getPrice()+tyre.getPrice();
    }

}
