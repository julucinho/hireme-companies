package com.capitolio.hiremecompanies.services.commons;

public interface SavingService <E>{

    E saveNew(E entityInstance);
    void save(E entityInstance);

}
