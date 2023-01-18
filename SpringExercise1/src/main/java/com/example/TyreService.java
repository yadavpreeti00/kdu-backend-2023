package com.example;

public class TyreService {

    private String tyreBrand;
    private Double tyrePrice;


    public TyreService(String tyreBrand, Double tyrePrice) {
        this.tyreBrand = tyreBrand;
        this.tyrePrice = tyrePrice;
    }

    @Override
    public String toString() {
        return "TyreService{" +
                "tyreBrand='" + tyreBrand + '\'' +
                ", tyrePrice=" + tyrePrice +
                '}';
    }

    public String getTyreBrand() {
        return tyreBrand;
    }

    public void setTyreBrand(String tyreBrand) {
        this.tyreBrand = tyreBrand;
    }

    public Double getTyrePrice() {
        return tyrePrice;
    }

    public void setTyrePrice(Double tyrePrice) {
        this.tyrePrice = tyrePrice;
    }
}
