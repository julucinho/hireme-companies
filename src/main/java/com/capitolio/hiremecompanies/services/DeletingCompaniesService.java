package com.capitolio.hiremecompanies.services;

import org.springframework.stereotype.Service;

@Service
public interface DeletingCompaniesService {
    void deleteCompanyBy(Long id);
}
