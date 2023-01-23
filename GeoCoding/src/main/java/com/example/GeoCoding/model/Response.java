package com.example.GeoCoding.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Response {

    private Integer status;
    private Object object;
    private String message;
}
