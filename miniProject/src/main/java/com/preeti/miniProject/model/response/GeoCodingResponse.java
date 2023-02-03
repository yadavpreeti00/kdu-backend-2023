package com.preeti.miniProject.model.response;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class GeoCodingResponse {
    private double latitude;
    private double longitude;
    private String label;
    private String name;
    private String type;
    private int distance;
    private String number;
    private String street;
    private String postal_code;
    private int confidence;
    private String region;
    private String region_code;
    private String administrative_area;
    private String neighbourhood;
    private String country;
    private String country_code;
    private String map_url;

}
