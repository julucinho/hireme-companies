package com.capitolio.hiremecompanies.dtos;

import com.capitolio.hiremecompanies.dtos.commons.Dto;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoleDto extends Dto {
    private Long id;
    private String name;
    private String description;
    private CompanyDto company;
}
