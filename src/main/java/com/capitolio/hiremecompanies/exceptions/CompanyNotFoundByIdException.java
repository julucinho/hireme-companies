package com.capitolio.hiremecompanies.exceptions;

import com.capitolio.hiremecompanies.exceptions.commons.NotFoundException;
import lombok.Getter;

@Getter
public class CompanyNotFoundByIdException extends NotFoundException {

    public CompanyNotFoundByIdException(Long id){
        super("The company of id ".concat(id.toString()).concat( "wasn't found."));
    }

}
