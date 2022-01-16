package com.capitolio.hiremecompanies.exceptions.commons;

public class NotFoundException extends RuntimeException {

    public NotFoundException(String message){
        super(message);
    }
}
