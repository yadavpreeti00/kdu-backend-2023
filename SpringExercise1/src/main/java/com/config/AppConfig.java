package com.config;

import com.example.TyreService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.example")
public class AppConfig {

    @Bean("tyre1")
    public TyreService tyre1() {
        return new TyreService("Bridgestone",450.0);
    }

    @Bean("tyre2")
    public TyreService tyre2() {
        return new TyreService("MRF",500.0);
    }

}
