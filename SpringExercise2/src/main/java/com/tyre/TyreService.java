package com.tyre;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;


@Configuration
public class TyreService {

    @Bean
    @Scope("prototype")
    public Tyre getTyre(String brand)
    {
        if(brand.equalsIgnoreCase("MRF"))
        {
            return new Tyre("MRF",700.8);
        }
        return new Tyre("Bridgestone",900.90);
    }
}
