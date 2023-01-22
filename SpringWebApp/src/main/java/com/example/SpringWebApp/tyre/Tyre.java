package com.example.SpringWebApp.tyre;



import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class Tyre {

    private String Brand;
    private Double price;

}
