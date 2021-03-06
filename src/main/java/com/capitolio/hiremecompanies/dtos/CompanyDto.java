package com.capitolio.hiremecompanies.dtos;

import com.capitolio.hiremecompanies.dtos.commons.Dto;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompanyDto extends Dto {

    private Long id;
    private String name;
    private String email;

}
