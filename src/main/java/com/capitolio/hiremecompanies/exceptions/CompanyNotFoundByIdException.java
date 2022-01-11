package com.capitolio.hiremecompanies.exceptions;

import lombok.Getter;

@Getter
public class CompanyNotFoundByIdException extends RuntimeException{

    public CompanyNotFoundByIdException(Long id){
        super("The company of id ".concat(id.toString()).concat( "wasn't found."));
    }

}
