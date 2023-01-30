package com.preeti.assignment2.controller;


import com.preeti.assignment2.entity.Address;
import com.preeti.assignment2.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/address")

public class AddressController
{
    @Autowired
    AddressService addressService;

    @PostMapping("/create")
    public ResponseEntity<Address> createAddress(@RequestBody Address address) {
        Address createdaddress= addressService.createAddress(address);
        return new ResponseEntity<>(createdaddress, HttpStatus.CREATED);
    }

    @GetMapping("/getAll/{username}")
    public ResponseEntity<List<Address>> getAllAddresses(@PathVariable String username) {
        List<Address> addresses = addressService.findAllAddressesByUserUsername(username);
        return new ResponseEntity<>(addresses, HttpStatus.OK);
    }

}
