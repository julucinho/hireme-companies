package com.capitolio.hiremecompanies.services.impl;

import com.capitolio.hiremecompanies.entities.CompanyEntity;
import com.capitolio.hiremecompanies.repositories.CompaniesRepository;
import com.capitolio.hiremecompanies.services.CompaniesValidationsService;
import com.capitolio.hiremecompanies.services.SavingCompaniesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SavingCompaniesServiceImpl implements SavingCompaniesService {

    private final CompaniesRepository companiesRepository;
    private final CompaniesValidationsService companiesValidationsService;

    @Override
    public CompanyEntity saveNew(CompanyEntity company) {
        return this.companiesRepository.save(company);
    }

    @Override
    public void save(CompanyEntity companyToBeUpdated) {
        this.companiesValidationsService.validateBeforeUpdating(companyToBeUpdated);
        this.companiesRepository.save(companyToBeUpdated);
    }
}
