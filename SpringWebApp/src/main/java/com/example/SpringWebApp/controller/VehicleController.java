package com.example.SpringWebApp.controller;
import com.example.SpringWebApp.vehicleinventory.Vehicle;
import com.example.SpringWebApp.service.VehicleCRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;


@ResponseBody
@Service
@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    @Autowired
    private VehicleCRUDService vehicleCRUDService;

    @GetMapping("/{id}")
    public Vehicle getVehicle(@PathVariable String id) {
        return vehicleCRUDService.getVehicle(id);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Vehicle> deleteVehicle(@RequestParam("id") String id) {
        try {
            vehicleCRUDService.deleteVehicle(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/createVehicle")
    public ResponseEntity<Vehicle> createVehicle(@RequestBody Vehicle vehicle) {
        vehicleCRUDService.createVehicle(vehicle);
        return new ResponseEntity<>(vehicle, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Vehicle> updateVehicle(@PathVariable String id, @Valid @RequestBody Vehicle vehicle) {
        try {
            Vehicle updatedVehicle = vehicleCRUDService.updateVehicle(id, vehicle);
            return new ResponseEntity<>(updatedVehicle, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/expensive")
    public ResponseEntity<Vehicle> getExpensiveVehicle(@RequestParam(required = false) String order) {
        try {
            Vehicle vehicle = vehicleCRUDService.getMostExpensiveVehicle(order);
            return new ResponseEntity<>(vehicle, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}