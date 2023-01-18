package com.example;

public class Vehicle {

    public SonySpeaker getSonySpeaker() {
        return sonySpeaker;
    }

    public void setSonySpeaker(SonySpeaker sonySpeaker) {
        this.sonySpeaker = sonySpeaker;
    }

    public BoshSpeaker getBoshSpeaker() {
        return boshSpeaker;
    }

    public void setBoshSpeaker(BoshSpeaker boshSpeaker) {
        this.boshSpeaker = boshSpeaker;
    }

    private SonySpeaker sonySpeaker;
    private BoshSpeaker boshSpeaker;
    private TyreService tyre;
    private Double totalPrice;

    @Override
    public String toString() {
        return "Vehicle{" +
                ", tyre=" + tyre +
                ", totalPrice=" + totalPrice +
                '}';
    }

    public Vehicle(TyreService tyre, SonySpeaker speaker) {
        this.sonySpeaker = speaker;
        this.tyre = tyre;
        this.totalPrice= speaker.getSpeakerPrice()+ tyre.getTyrePrice();
    }

    public Vehicle(TyreService tyre, BoshSpeaker speaker) {
        this.boshSpeaker = speaker;
        this.tyre = tyre;
        this.totalPrice= speaker.getSpeakerPrice()+ tyre.getTyrePrice();
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }


    public TyreService getTyre() {
        return tyre;
    }

    public void setTyre(TyreService tyre) {
        this.tyre = tyre;
    }


}
