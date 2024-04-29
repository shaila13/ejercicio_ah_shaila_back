package com.shaila.ejercicio.infraestructure.exception;

import com.shaila.ejercicio.infraestructure.dto.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
/**
 * Class that handles global exceptions of the application.
 * Defines methods to handle specific exceptions, such as PriceNotFoundException and InvalidParameterException.
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
    /**
     * Handles the PriceNotFoundException exception.
     *
     * @param ex The PriceNotFoundException exception.
     * @return ResponseEntity with an ErrorDto object and HTTP status 404 NOT FOUND.
     */
    @ExceptionHandler(PriceNotFoundException.class)
    public ResponseEntity<Object> handlePriceNotFoundException(PriceNotFoundException ex) {
        log.error("Price not found: {}", ex.getMessage());
        ErrorDto apiError = new ErrorDto(HttpStatus.NOT_FOUND, ex.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }
    /**
     * Handles the InvalidParameterException exception.
     *
     * @param ex The InvalidParameterException exception.
     * @return ResponseEntity with an ErrorDto object and HTTP status 400 BAD REQUEST.
     */
    @ExceptionHandler(InvalidParameterException.class)
    public ResponseEntity<Object> handleInvalidParameterException(InvalidParameterException ex) {
        log.error("Invalid parameter: {}", ex.getMessage());

        ErrorDto apiError = new ErrorDto(HttpStatus.BAD_REQUEST, ex.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }
}