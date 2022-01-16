package com.capitolio.hiremecompanies.repositories;

import com.capitolio.hiremecompanies.entities.CompanyEntity;
import com.capitolio.hiremecompanies.entities.RoleEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepository extends JpaRepository<RoleEntity, Long> {
    Page<RoleEntity> findAllByCompany(Pageable pageable, CompanyEntity company);
}
