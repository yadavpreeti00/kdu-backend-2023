package com.preeti.miniProject.exception;

public class DeviceAlreadyPurchasedException extends RuntimeException {

    public DeviceAlreadyPurchasedException()
    {
        super(String.format("Device Already purchased"));
    }
}
