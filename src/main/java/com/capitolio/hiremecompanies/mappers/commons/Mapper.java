package com.capitolio.hiremecompanies.mappers.commons;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.experimental.UtilityClass;

@UtilityClass
public class Mapper {

    public static MapperAux map(Object source){
        return new MapperAux(new ObjectMapper(), source);
    }

    @AllArgsConstructor
    public static class MapperAux {
        private final ObjectMapper objectMapper;
        private final Object source;

        public <T> T to(Class<T> destinationType){
            return this.objectMapper.convertValue(this.source, destinationType);
        }

    }
}
