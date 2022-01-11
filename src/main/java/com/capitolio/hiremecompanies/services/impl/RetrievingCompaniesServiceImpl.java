package com.capitolio.hiremecompanies.services.impl;

import com.capitolio.hiremecompanies.entities.CompanyEntity;
import com.capitolio.hiremecompanies.repositories.CompaniesRepository;
import com.capitolio.hiremecompanies.services.RetrievingCompaniesService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RetrievingCompaniesServiceImpl implements RetrievingCompaniesService {

    private final CompaniesRepository companiesRepository;

    @Override
    public Optional<CompanyEntity> retrieveCompanyBy(Long id) {
        return this.companiesRepository.findById(id);
    }

    @Override
    public Page<CompanyEntity> retrieveCompaniesBy(Integer pageNumber, Integer pageSize) {
        return this.companiesRepository.findAll(PageRequest.of(pageNumber, pageSize));
    }
}
