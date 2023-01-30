package com.preeti.assignment2.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddProductToCartRequest {

    private String username;
    private UUID productId;
    private Integer quantity;
}
