package com.capitolio.hiremecompanies.services;

import com.capitolio.hiremecompanies.entities.CompanyEntity;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface RetrievingCompaniesService {
    Optional<CompanyEntity> retrieveCompanyBy(Long id);
    Page<CompanyEntity> retrieveCompaniesBy(Integer pageNumber, Integer pageSize);
}
