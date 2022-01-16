package com.capitolio.hiremecompanies.services.impl;

import com.capitolio.hiremecompanies.repositories.RolesRepository;
import com.capitolio.hiremecompanies.services.DeletingRolesService;
import com.capitolio.hiremecompanies.services.RetrievingRolesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeletingRolesServiceImpl implements DeletingRolesService {

    private final RetrievingRolesService retrievingRolesService;
    private final RolesRepository rolesRepository;

    @Override
    public void deleteInstanceByIts(Long id) {
        if (this.retrievingRolesService.retrieveInstanceBy(id).isPresent())
            this.rolesRepository.deleteById(id);
    }
}
