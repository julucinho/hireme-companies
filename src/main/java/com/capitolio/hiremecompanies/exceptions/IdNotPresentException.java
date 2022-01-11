package com.capitolio.hiremecompanies.exceptions;

import lombok.Getter;

@Getter
public class IdNotPresentException extends RuntimeException{

    public IdNotPresentException(){
        super("The instance came without the presence of an ID. That is not allowed for the operation being executed.");
    }

}
