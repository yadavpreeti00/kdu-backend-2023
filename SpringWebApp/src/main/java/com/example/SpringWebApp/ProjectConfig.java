package com.example.SpringWebApp;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.example.SpringWebApp.speaker","com.example.SpringWebApp.tyre","com.example.SpringWebApp.vehicle","com.example.SpringWebApp.vehicleinventory","com.example.SpringWebApp.repository","com.example.SpringWebApp.service","com.example.SpringWebApp.controller"})
public class ProjectConfig {
}
