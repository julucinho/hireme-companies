package com.capitolio.hiremecompanies.controllers;

import com.capitolio.hiremecompanies.dtos.CompanyDto;
import com.capitolio.hiremecompanies.services.DeletingCompaniesService;
import com.capitolio.hiremecompanies.services.RetrievingCompaniesService;
import com.capitolio.hiremecompanies.services.SavingCompaniesService;
import com.capitolio.hiremecompanies.utils.CompaniesMapper;
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
    public ResponseEntity<CompanyDto> saveNewUser(@RequestBody CompanyDto newCompany){
        var userJustSaved = this.savingCompaniesService.saveNew(CompaniesMapper.toEntity(newCompany));
        return ResponseEntity.status(201).body(CompaniesMapper.toDto(userJustSaved));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompanyDto> retrieveUserById(@PathVariable Long id){
        var user = this.retrievingCompaniesService.retrieveCompanyBy(id).map(CompaniesMapper::toDto).orElse(new CompanyDto());
        return ResponseEntity.ok(user);
    }

    @GetMapping
    public ResponseEntity<Page<CompanyDto>> retrieveUsersPaginated(@RequestParam Integer pageNumber, @RequestParam Integer pageSize){
        var users = this.retrievingCompaniesService.retrieveCompaniesBy(pageNumber, pageSize).map(CompaniesMapper::toDto);
        return ResponseEntity.ok(users);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateUser(@PathVariable Long id, @RequestBody CompanyDto companyToBeUpdated){
        companyToBeUpdated.setId(id);
        this.savingCompaniesService.save(CompaniesMapper.toEntity(companyToBeUpdated));
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        this.deletingCompaniesService.deleteCompanyBy(id);
        return ResponseEntity.noContent().build();
    }


}
