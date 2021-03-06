package com.capitolio.hiremecompanies.services;

import com.capitolio.hiremecompanies.entities.CompanyEntity;
import com.capitolio.hiremecompanies.services.commons.SavingService;
import org.springframework.stereotype.Service;

@Service
public interface SavingCompaniesService extends SavingService<CompanyEntity> {
}
