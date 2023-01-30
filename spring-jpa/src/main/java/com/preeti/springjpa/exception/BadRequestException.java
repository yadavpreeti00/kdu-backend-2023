package com.preeti.springjpa.exception;

import lombok.extern.slf4j.Slf4j;

import java.sql.Time;

@Slf4j
public class BadRequestException extends RuntimeException
{
    public BadRequestException(Time endTime)
    {
        super(String.format("Provided shift user's end time doesn't match with %s", endTime));
        log.info("Provided shift user's end time doesn't match with "+endTime);
    }
}
