package com.speaker;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class Speaker {
    private String brand;
    private Double price;
}
