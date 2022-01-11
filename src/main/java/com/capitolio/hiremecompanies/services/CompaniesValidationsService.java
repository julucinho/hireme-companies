package com.capitolio.hiremecompanies.services;

import com.capitolio.hiremecompanies.entities.CompanyEntity;
import org.springframework.stereotype.Service;

@Service
public interface CompaniesValidationsService {
    void validateBeforeUpdating(CompanyEntity companyToBeUpdated);
}
