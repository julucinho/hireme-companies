package com.capitolio.hiremecompanies.services.impl;

import com.capitolio.hiremecompanies.repositories.CompaniesRepository;
import com.capitolio.hiremecompanies.services.DeletingCompaniesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeletingCompaniesServiceImpl implements DeletingCompaniesService {

    private final CompaniesRepository companiesRepository;

    @Override
    public void deleteCompanyBy(Long id) {
        this.companiesRepository.deleteById(id);
    }
}
