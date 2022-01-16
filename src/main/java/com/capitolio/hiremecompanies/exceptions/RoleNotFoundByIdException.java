package com.capitolio.hiremecompanies.exceptions;

import com.capitolio.hiremecompanies.exceptions.commons.NotFoundException;

public class RoleNotFoundByIdException extends NotFoundException {

    public RoleNotFoundByIdException(Long id) {
        super("The role of id ".concat(id.toString()).concat("wasn't found."));
    }
}

