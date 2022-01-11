package com.capitolio.hiremecompanies.repositories;

import com.capitolio.hiremecompanies.entities.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompaniesRepository extends JpaRepository<CompanyEntity, Long> {
}
