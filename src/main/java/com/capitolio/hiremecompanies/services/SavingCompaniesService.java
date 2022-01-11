package com.capitolio.hiremecompanies.services;

import com.capitolio.hiremecompanies.entities.CompanyEntity;
import org.springframework.stereotype.Service;

@Service
public interface SavingCompaniesService {
    CompanyEntity saveNew(CompanyEntity toEntity);
    void save(CompanyEntity companyToBeUpdated);
}
