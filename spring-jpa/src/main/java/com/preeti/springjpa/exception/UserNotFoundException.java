package com.preeti.springjpa.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;
@Slf4j

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(UUID id) {
        super(String.format("User with id %s not found", id));
        log.info("User with id "+id+" not found");
    }
}
