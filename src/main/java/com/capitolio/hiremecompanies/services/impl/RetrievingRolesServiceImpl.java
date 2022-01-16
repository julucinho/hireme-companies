package com.capitolio.hiremecompanies.services.impl;

import com.capitolio.hiremecompanies.entities.CompanyEntity;
import com.capitolio.hiremecompanies.entities.RoleEntity;
import com.capitolio.hiremecompanies.repositories.RolesRepository;
import com.capitolio.hiremecompanies.services.RetrievingRolesService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RetrievingRolesServiceImpl implements RetrievingRolesService {

    private final RolesRepository rolesRepository;

    @Override
    public Optional<RoleEntity> retrieveInstanceBy(Long id) {
        return this.rolesRepository.findById(id);
    }

    @Override
    public Page<RoleEntity> retrieveInstanceBy(Integer pageNumber, Integer pageSize) {
        return this.rolesRepository.findAll(PageRequest.of(pageNumber, pageSize));
    }

    @Override
    public Page<RoleEntity> retrieveInstancesByCompany(Integer pageNumber, Integer pageSize, Long companyId) {
        return this.rolesRepository.findAllByCompany(PageRequest.of(pageNumber, pageSize), CompanyEntity.builder().id(companyId).build());
    }
}
