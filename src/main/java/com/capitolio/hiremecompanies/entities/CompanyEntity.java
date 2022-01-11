package com.capitolio.hiremecompanies.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompanyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="company_id")
    private Long id;
    @Column(name="company_name")
    private String name;
    @Column(name="company_email")
    private String email;

}
