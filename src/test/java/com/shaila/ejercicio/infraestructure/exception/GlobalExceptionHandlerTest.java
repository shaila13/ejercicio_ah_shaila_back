package com.shaila.ejercicio.infraestructure.exception;

import com.shaila.ejercicio.infraestructure.dto.ErrorDto;
import com.shaila.ejercicio.infraestructure.utils.DataConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

class GlobalExceptionHandlerTest {

    String nonNumericValue = "abc";

    String errorMessagePriceNotFound = "Price not found";
    String errorMessageInvalidParameter = "Invalid parameter";

    GlobalExceptionHandler globalExceptionHandler;

    @BeforeEach
    void setUp() {
        globalExceptionHandler = new GlobalExceptionHandler();
    }

    @Test
    void handlePriceNotFoundException() {
        PriceNotFoundException exception = new PriceNotFoundException(errorMessagePriceNotFound);
        ResponseEntity<Object> responseEntity = globalExceptionHandler.handlePriceNotFoundException(exception);
        ErrorDto errorDto = (ErrorDto) responseEntity.getBody();
        assertEquals(errorMessagePriceNotFound, errorDto.getMessage());
        assertEquals(HttpStatus.NOT_FOUND, errorDto.getStatus());
    }

    @Test
    void handleInvalidParameterException() {
        InvalidParameterException exception = new InvalidParameterException(errorMessageInvalidParameter);
        ResponseEntity<Object> responseEntity = globalExceptionHandler.handleInvalidParameterException(exception);
        ErrorDto errorDto = (ErrorDto) responseEntity.getBody();
        assertEquals(errorMessageInvalidParameter, errorDto.getMessage());
        assertEquals(HttpStatus.BAD_REQUEST, errorDto.getStatus());
    }

    @Test
    public void shouldThrowExceptionWhenGivenNonNumericValue() {
        assertThrows(InvalidParameterException.class, () -> DataConverter.validateNumericParameters(nonNumericValue));
    }

}