package com.capitolio.hiremecompanies.services.impl;

import com.capitolio.hiremecompanies.entities.CompanyEntity;
import com.capitolio.hiremecompanies.exceptions.CompanyNotFoundByIdException;
import com.capitolio.hiremecompanies.exceptions.IdNotPresentException;
import com.capitolio.hiremecompanies.services.CompaniesValidationsService;
import com.capitolio.hiremecompanies.services.RetrievingCompaniesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static java.util.Optional.ofNullable;

@Service
@RequiredArgsConstructor
public class CompaniesValidationsServiceImpl implements CompaniesValidationsService {

    private final RetrievingCompaniesService retrievingCompaniesService;

    @Override
    public void validateBeforeUpdating(CompanyEntity companyToBeUpdated) {
        ofNullable(companyToBeUpdated.getId()).orElseThrow(IdNotPresentException::new);
        this.retrievingCompaniesService.retrieveInstanceBy(companyToBeUpdated.getId()).orElseThrow(() -> new CompanyNotFoundByIdException(companyToBeUpdated.getId()));
    }
}
