package com.capitolio.hiremecompanies.services.commons;

import org.springframework.data.domain.Page;

import java.util.Optional;

public interface RetrievingService<E, I> {
    Optional<E> retrieveInstanceBy(I id);
    Page<E> retrieveInstanceBy(Integer pageNumber, Integer pageSize);
}
