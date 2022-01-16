package com.capitolio.hiremecompanies.controllers;

import com.capitolio.hiremecompanies.dtos.RoleDto;
import com.capitolio.hiremecompanies.exceptions.RoleNotFoundByIdException;
import com.capitolio.hiremecompanies.services.DeletingRolesService;
import com.capitolio.hiremecompanies.services.RetrievingRolesService;
import com.capitolio.hiremecompanies.services.SavingRolesService;
import com.capitolio.hiremecompanies.mappers.RolesMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/roles")
@RequiredArgsConstructor
public class RolesController {

    private final SavingRolesService savingRolesService;
    private final RetrievingRolesService retrievingRolesService;
    private final DeletingRolesService deletingRolesService;

    @GetMapping("/company/{companyId}")
    public ResponseEntity<Page<RoleDto>> retrieveRolesByCompany(
            @RequestParam Integer pageNumber,
            @RequestParam Integer pageSize,
            @PathVariable Long companyId){
        var rolesByCompany = this.retrievingRolesService.retrieveInstancesByCompany(pageNumber, pageSize, companyId).map(RolesMapper::toDto);
        return ResponseEntity.ok(rolesByCompany);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoleDto> retrieveById(@PathVariable Long id){
        var role = this.retrievingRolesService.retrieveInstanceBy(id).map(RolesMapper::toDto).orElseThrow(() -> new RoleNotFoundByIdException(id));
        return ResponseEntity.ok(role);
    }

    @PostMapping
    public ResponseEntity<RoleDto> saveNew(@RequestBody RoleDto role){
        var justSavedRole = this.savingRolesService.saveNew(RolesMapper.toEntity(role));
        return ResponseEntity.status(201).body(RolesMapper.toDto(justSavedRole));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> save(@RequestBody RoleDto role, @PathVariable Long id){
        role.setId(id);
        this.savingRolesService.save(RolesMapper.toEntity(role));
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        this.deletingRolesService.deleteInstanceByIts(id);
        return ResponseEntity.noContent().build();
    }

}
