package com.preeti.assignment2.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;

@Slf4j
@ResponseStatus(value = HttpStatus.NOT_FOUND)

public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException(UUID id)
    {
        super(String.format("Product with id %s not found", id));
        log.info("Product with id "+id+" not found");
    }
}
