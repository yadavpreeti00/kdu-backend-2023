package com.preeti.miniProject.exception;

public class DeviceUsernameNotFoundException extends RuntimeException {
    public DeviceUsernameNotFoundException(String deviceUsername) {
        super((String.format("Device with user name %s not found",deviceUsername)));
    }
}
