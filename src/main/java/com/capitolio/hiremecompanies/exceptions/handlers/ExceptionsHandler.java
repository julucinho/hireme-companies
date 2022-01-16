package com.capitolio.hiremecompanies.exceptions.handlers;

import com.capitolio.hiremecompanies.dtos.ErrorMessageDto;
import com.capitolio.hiremecompanies.exceptions.commons.BadRequestException;
import com.capitolio.hiremecompanies.exceptions.commons.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler(value = BadRequestException.class)
    public ResponseEntity<ErrorMessageDto> handle(BadRequestException exception){
        return ResponseEntity.badRequest().body(new ErrorMessageDto(exception.getMessage()));
    }

    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<ErrorMessageDto> handle(NotFoundException exception){
        return ResponseEntity.notFound().build();
    }

}
