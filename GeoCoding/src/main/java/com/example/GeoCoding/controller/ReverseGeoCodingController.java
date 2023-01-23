package com.example.GeoCoding.controller;

import com.example.GeoCoding.model.Response;
import com.example.GeoCoding.model.ResponseData;
import com.example.GeoCoding.service.ReverseGeoCodingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@ResponseBody
@Service
@RestController
@RequestMapping("/coordinates")
public class ReverseGeoCodingController {

    @Autowired
    ReverseGeoCodingService reverseGeoCodingService;

    @GetMapping("/get")
    public ResponseEntity<Response> getAddress(@RequestParam("latitude") double latitude,@RequestParam("longitude") double longitude)
    {
        ResponseData responseData= reverseGeoCodingService.getAddress(latitude,longitude);
        Response response=new Response();
        response.setStatus(200);
        response.setMessage("Request Successfully Completed.");
        response.setObject(responseData);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }



}
