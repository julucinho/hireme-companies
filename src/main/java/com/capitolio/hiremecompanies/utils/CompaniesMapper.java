package com.capitolio.hiremecompanies.utils;

import com.capitolio.hiremecompanies.dtos.CompanyDto;
import com.capitolio.hiremecompanies.entities.CompanyEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CompaniesMapper {

    public static CompanyEntity toEntity(CompanyDto userDto){
        return Mapper.map(userDto).to(CompanyEntity.class);
    }

    public static CompanyDto toDto(CompanyEntity userEntity){
        return Mapper.map(userEntity).to(CompanyDto.class);
    }

}
