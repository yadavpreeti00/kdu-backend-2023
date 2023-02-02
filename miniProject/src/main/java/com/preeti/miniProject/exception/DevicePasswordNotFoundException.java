package com.preeti.miniProject.exception;

public class DevicePasswordNotFoundException extends RuntimeException {
    public DevicePasswordNotFoundException(String devicePassword) {
        super(String.format("Device password is incorrect"));
    }
}
