package com.capitolio.hiremecompanies.services;

import com.capitolio.hiremecompanies.entities.CompanyEntity;
import com.capitolio.hiremecompanies.services.commons.RetrievingService;
import org.springframework.stereotype.Service;

@Service
public interface RetrievingCompaniesService extends RetrievingService<CompanyEntity, Long> {}
