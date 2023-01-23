package com.example.GeoCoding.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Data
@Getter
@Setter
public class ResponseData {

    private List<GeoCodingResponse> data=new ArrayList<>();
}
