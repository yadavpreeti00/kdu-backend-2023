package com.mains;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.vehicle","com.tyre","com.speaker","com.vehicleinventory"})
public class ProjectConfig {
}
