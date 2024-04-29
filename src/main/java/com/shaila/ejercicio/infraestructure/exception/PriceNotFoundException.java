package com.shaila.ejercicio.infraestructure.exception;

/**
 * Custom exception to indicate that a price was not found.
 * It is thrown when searching for a price in the database and none is found for the provided parameters.
 */
public class PriceNotFoundException extends RuntimeException {
    /**
     * Constructor that accepts an error message.
     *
     * @param message Error message describing the cause of the exception.
     */
    public PriceNotFoundException(String message) {
        super(message);
    }
}