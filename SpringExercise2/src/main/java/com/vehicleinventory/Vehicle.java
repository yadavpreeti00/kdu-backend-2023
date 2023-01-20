package com.vehicleinventory;


import com.speaker.Speaker;
import com.tyre.Tyre;
import lombok.Data;

@Data
public class Vehicle {
    private Tyre tyre;
    private Speaker speaker;
    private Double totalPrice;

    public Vehicle(Tyre tyre,Speaker speaker)
    {
        this.speaker=speaker;
        this.tyre=tyre;
        this.totalPrice= speaker.getPrice()+tyre.getPrice();
    }
}
