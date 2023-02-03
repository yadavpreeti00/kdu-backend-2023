package com.preeti.miniProject.exception;

import java.util.UUID;

public class RoomNotFoundException extends RuntimeException{
    public RoomNotFoundException(UUID id) {
        super(String.format("Home with home id %s not found",id));
    }
}
