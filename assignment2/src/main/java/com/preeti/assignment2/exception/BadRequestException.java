package com.preeti.assignment2.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;

@Slf4j
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class BadRequestException extends RuntimeException{

    public BadRequestException(Integer quantity)
    {
        super(String.format("Quantity %s exceeds the available quantity",quantity));
        log.info("Quantity "+quantity+" exceeds the available quantity");
    }
}
