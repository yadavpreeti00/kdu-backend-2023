package com.preeti.miniProject.service;

import com.preeti.miniProject.model.response.ReverseGeoCodingResponseData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;



import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.client.RestTemplate;


@Service
public class ReverseGeoCodingService {

    @Value("${apiKey}")
    private String apiKey;
    private final String apiEndpoint="http://api.positionstack.com/v1/reverse";


    @Cacheable(value = "reversegeocoding", key = "#latitude + ',' + #longitude")
    public String getAddress(double latitude, double longitude)
    {
        String url = apiEndpoint + "?access_key=" + apiKey + "&query=" + latitude+","+longitude;
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);
        ObjectMapper mapper = new ObjectMapper();
        ReverseGeoCodingResponseData responseData =null;
        try {
            responseData = mapper.readValue(response, ReverseGeoCodingResponseData.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        String address=responseData.getData().get(0).getName()+" "+responseData.getData().get(0).getPostal_code()+" "
                +responseData.getData().get(0).getStreet()+" "+responseData.getData().get(0).getCountry();
        return address;
    }

}
