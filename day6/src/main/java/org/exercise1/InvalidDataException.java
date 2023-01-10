package org.exercise1;

public class InvalidDataException extends RuntimeException{

    InvalidDataException(String message , Throwable e){
        super(message ,e);
    }
}
