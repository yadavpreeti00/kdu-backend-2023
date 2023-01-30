package com.preeti.assignment2.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AddressNotFoundException extends RuntimeException {
    public AddressNotFoundException(String addressTag) {
        super(String.format("Address with tag %s not found",addressTag));
        log.info("Address with tag "+addressTag+" not found");
    }
}
