package com.example;

import org.springframework.stereotype.Component;

@Component
public class BoshSpeaker {


    private String speakerBrand;
    private Double speakerPrice;

    @Override
    public String toString() {
        return "SpeakerService{" +
                "speakerBrand='" + speakerBrand + '\'' +
                ", speakerPrice=" + speakerPrice +
                '}';
    }

    public String getSpeakerBrand() {
        return speakerBrand;
    }

    public void setSpeakerBrand(String speakerBrand) {
        this.speakerBrand = speakerBrand;
    }

    public Double getSpeakerPrice() {
        return speakerPrice;
    }

    public void setSpeakerPrice(Double speakerPrice) {
        this.speakerPrice = speakerPrice;
    }

}
