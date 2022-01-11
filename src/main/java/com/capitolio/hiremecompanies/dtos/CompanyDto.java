package com.capitolio.hiremecompanies.dtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompanyDto {

    private Long id;
    private String name;
    private String email;

}
