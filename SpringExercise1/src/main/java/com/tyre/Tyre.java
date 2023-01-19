package com.tyre;



import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Getter
@Setter
@ToString
@Builder
@Component
public class Tyre {

    private String Brand;
    private Double price;

}
