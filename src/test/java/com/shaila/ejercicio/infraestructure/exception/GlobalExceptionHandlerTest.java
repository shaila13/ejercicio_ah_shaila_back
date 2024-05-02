package com.shaila.ejercicio.infraestructure.exception;

import com.shaila.ejercicio.infraestructure.dto.ErrorDto;
import com.shaila.ejercicio.infraestructure.utils.DataConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

class GlobalExceptionHandlerTest {

    private static final String NON_NUMERIC_VALUE = "abc";
    private static final String ERROR_MESSAGE_PRICE_NOT_FOUND = "Price not found";
    private static final String ERROR_MESSAGE_INVALID_PARAMETER = "Invalid parameter";

    private GlobalExceptionHandler globalExceptionHandler;

    @BeforeEach
    void setUp() {
        globalExceptionHandler = new GlobalExceptionHandler();
    }

    @Test
    void handlePriceNotFoundException() {
        PriceNotFoundException exception = new PriceNotFoundException(ERROR_MESSAGE_PRICE_NOT_FOUND);
        ResponseEntity<Object> responseEntity = globalExceptionHandler.handlePriceNotFoundException(exception);
        ErrorDto errorDto = (ErrorDto) responseEntity.getBody();
        assertEquals(ERROR_MESSAGE_PRICE_NOT_FOUND, errorDto.getMessage());
        assertEquals(HttpStatus.NOT_FOUND, errorDto.getStatus());
    }

    @Test
    void handleInvalidParameterException() {
        InvalidParameterException exception = new InvalidParameterException(ERROR_MESSAGE_INVALID_PARAMETER);
        ResponseEntity<Object> responseEntity = globalExceptionHandler.handleInvalidParameterException(exception);
        ErrorDto errorDto = (ErrorDto) responseEntity.getBody();
        assertEquals(ERROR_MESSAGE_INVALID_PARAMETER, errorDto.getMessage());
        assertEquals(HttpStatus.BAD_REQUEST, errorDto.getStatus());
    }

    @Test
    public void shouldThrowExceptionWhenGivenNonNumericValue() {
        assertThrows(InvalidParameterException.class, () -> DataConverter.validateNumericParameters(NON_NUMERIC_VALUE));
    }

}