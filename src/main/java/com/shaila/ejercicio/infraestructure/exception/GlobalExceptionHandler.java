package com.shaila.ejercicio.infraestructure.exception;

import com.shaila.ejercicio.domain.models.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
/**
 * Clase que maneja las excepciones globales de la aplicación.
 * Define métodos para manejar excepciones específicas, como PriceNotFoundException y InvalidParameterException.
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
    /**
     * Maneja la excepción PriceNotFoundException.
     *
     * @param ex Excepción PriceNotFoundException.
     * @return ResponseEntity con un objeto ErrorDto y el estado HTTP 404 NOT FOUND.
     */
    @ExceptionHandler(PriceNotFoundException.class)
    public ResponseEntity<Object> handlePriceNotFoundException(PriceNotFoundException ex) {
        log.error("Precio no encontrado: {}", ex.getMessage());
        ErrorDto apiError = new ErrorDto(HttpStatus.NOT_FOUND, ex.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }
    /**
     * Maneja la excepción InvalidParameterException.
     *
     * @param ex Excepción InvalidParameterException.
     * @return ResponseEntity con un objeto ErrorDto y el estado HTTP 400 BAD REQUEST.
     */
    @ExceptionHandler(InvalidParameterException.class)
    public ResponseEntity<Object> handleInvalidParameterException(InvalidParameterException ex) {
        log.error("Parámetro inválido: {}", ex.getMessage());

        ErrorDto apiError = new ErrorDto(HttpStatus.BAD_REQUEST, ex.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }
}
