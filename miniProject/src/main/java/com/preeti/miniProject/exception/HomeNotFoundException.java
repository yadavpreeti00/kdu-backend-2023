package com.preeti.miniProject.exception;

import java.util.UUID;

public class HomeNotFoundException extends RuntimeException {
    public HomeNotFoundException(UUID id) {
        super(String.format("Home with home id %s not found",id));
    }
}
