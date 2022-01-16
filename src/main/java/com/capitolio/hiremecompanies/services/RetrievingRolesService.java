package com.capitolio.hiremecompanies.services;

import com.capitolio.hiremecompanies.entities.RoleEntity;
import com.capitolio.hiremecompanies.services.commons.RetrievingService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public interface RetrievingRolesService extends RetrievingService<RoleEntity, Long> {
    Page<RoleEntity> retrieveInstancesByCompany(Integer pageNumber, Integer pageSize, Long companyId);
}
