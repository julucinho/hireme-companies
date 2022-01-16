package com.capitolio.hiremecompanies.controllers;

import com.capitolio.hiremecompanies.dtos.CompanyDto;
import com.capitolio.hiremecompanies.exceptions.CompanyNotFoundByIdException;
import com.capitolio.hiremecompanies.services.DeletingCompaniesService;
import com.capitolio.hiremecompanies.services.RetrievingCompaniesService;
import com.capitolio.hiremecompanies.services.SavingCompaniesService;
import com.capitolio.hiremecompanies.mappers.CompaniesMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/companies")
@RequiredArgsConstructor
public class CompaniesController {

    private final SavingCompaniesService savingCompaniesService;
    private final RetrievingCompaniesService retrievingCompaniesService;
    private final DeletingCompaniesService deletingCompaniesService;

    @PostMapping
    public ResponseEntity<CompanyDto> saveNewCompany(@RequestBody CompanyDto newCompany){
        var companyJustSaved = this.savingCompaniesService.saveNew(CompaniesMapper.toEntity(newCompany));
        return ResponseEntity.status(201).body(CompaniesMapper.toDto(companyJustSaved));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompanyDto> retrieveCompanyById(@PathVariable Long id){
        var company = this.retrievingCompaniesService.retrieveInstanceBy(id).map(CompaniesMapper::toDto).orElseThrow(() -> new CompanyNotFoundByIdException(id));
        return ResponseEntity.ok(company);
    }

    @GetMapping
    public ResponseEntity<Page<CompanyDto>> retrieveCompaniesPaginated(@RequestParam Integer pageNumber, @RequestParam Integer pageSize){
        var companies = this.retrievingCompaniesService.retrieveInstanceBy(pageNumber, pageSize).map(CompaniesMapper::toDto);
        return ResponseEntity.ok(companies);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateCompany(@PathVariable Long id, @RequestBody CompanyDto companyToBeUpdated){
        companyToBeUpdated.setId(id);
        this.savingCompaniesService.save(CompaniesMapper.toEntity(companyToBeUpdated));
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompany(@PathVariable Long id){
        this.deletingCompaniesService.deleteInstanceByIts(id);
        return ResponseEntity.noContent().build();
    }

}
