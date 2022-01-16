package com.capitolio.hiremecompanies.mappers;

import com.capitolio.hiremecompanies.dtos.RoleDto;
import com.capitolio.hiremecompanies.entities.RoleEntity;
import com.capitolio.hiremecompanies.mappers.commons.Mapper;
import lombok.experimental.UtilityClass;

@UtilityClass
public class RolesMapper {

    public static RoleDto toDto(RoleEntity roleEntity) {
        return Mapper.map(roleEntity).to(RoleDto.class);
    }

    public static RoleEntity toEntity(RoleDto roleDto){
        return Mapper.map(roleDto).to(RoleEntity.class);
    }

}
