package com.example.GeoCoding.service;

import com.example.GeoCoding.model.GeoCodingResponse;
import com.example.GeoCoding.model.ResponseData;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ReverseGeoCodingService {

    private final String apiKey="6b60a94ff2eb5c147db59d94f5256484";
    private final String apiEndpoint="http://api.positionstack.com/v1/reverse";


    @Cacheable(value = "reversegeocoding", key = "#latitude + ',' + #longitude")
    public ResponseData getAddress(double latitude,double longitude)
    {
        String url = apiEndpoint + "?access_key=" + apiKey + "&query=" + latitude+","+longitude;
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);
        ObjectMapper mapper = new ObjectMapper();
        ResponseData responseData =null;
        try {
            responseData = mapper.readValue(response, ResponseData.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return responseData;
    }

}
