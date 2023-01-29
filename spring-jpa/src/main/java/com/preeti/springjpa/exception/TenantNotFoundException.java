package com.preeti.springjpa.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
@Slf4j
public class TenantNotFoundException extends RuntimeException {
    public TenantNotFoundException(UUID id) {

        super(String.format("Tenant with id %s not found", id));
        log.info("Tenant with tenant id "+id+" not found");
    }
}
