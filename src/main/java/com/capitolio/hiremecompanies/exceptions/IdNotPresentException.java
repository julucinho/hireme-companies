package com.capitolio.hiremecompanies.exceptions;

import com.capitolio.hiremecompanies.exceptions.commons.BadRequestException;
import lombok.Getter;

@Getter
public class IdNotPresentException extends BadRequestException {

    public IdNotPresentException(){
        super("The instance came without the presence of an ID. That is not allowed for the operation being executed.");
    }

}
