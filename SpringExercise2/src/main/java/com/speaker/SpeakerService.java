package com.speaker;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter

@Component
public class SpeakerService {
    public Speaker getSpeaker(String brand)
    {
        if(brand.equalsIgnoreCase("bosh"))
        {
            return new Speaker("Bosh",450.00);
        }
        return new Speaker("Sony",500.50);

    }
}
