package com.example.GeoCoding.controller;

import com.example.GeoCoding.model.Response;
import com.example.GeoCoding.model.ResponseData;
import com.example.GeoCoding.service.GeoCodingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@ResponseBody
@Service
@RestController
@RequestMapping("/address")
public class GeoCodingController {

    @Autowired
    GeoCodingService geoCodingService;

    @GetMapping("/get")

    public ResponseEntity<Response> getLatitudeLongitude(@RequestParam("location") String location)
    {
        ResponseData responseData= geoCodingService.getLatitudeLongitude(location);
        Response response=new Response();
        response.setStatus(200);
        response.setMessage("Request Successfully Completed.");
        response.setObject(responseData);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }



}
