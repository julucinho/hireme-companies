package com.capitolio.hiremecompanies.exceptions.commons;

public class BadRequestException extends RuntimeException{

    public BadRequestException(String message){
        super(message);
    }

}