package com.capitolio.hiremecompanies.services.impl;

import com.capitolio.hiremecompanies.entities.RoleEntity;
import com.capitolio.hiremecompanies.exceptions.IdNotPresentException;
import com.capitolio.hiremecompanies.exceptions.RoleNotFoundByIdException;
import com.capitolio.hiremecompanies.repositories.RolesRepository;
import com.capitolio.hiremecompanies.services.RetrievingRolesService;
import com.capitolio.hiremecompanies.services.SavingRolesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SavingRolesServiceImpl implements SavingRolesService {

    private final RolesRepository rolesRepository;
    private final RetrievingRolesService retrievingRolesService;

    @Override
    public RoleEntity saveNew(RoleEntity entityInstance) {
        return this.rolesRepository.save(entityInstance);
    }

    @Override
    public void save(RoleEntity entityInstance) {
        var roleId = Optional.ofNullable(entityInstance.getId()).orElseThrow(IdNotPresentException::new);
        if (this.retrievingRolesService.retrieveInstanceBy(roleId).isPresent())
            this.rolesRepository.save(entityInstance);
        throw new RoleNotFoundByIdException(roleId);
    }
}
