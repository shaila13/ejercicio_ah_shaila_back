package com.shaila.ejercicio.infraestructure.exception;

/**
 * Custom exception to indicate an invalid parameter.
 * It is thrown when a provided parameter is detected to be invalid or in an incorrect format.
 */
public class InvalidParameterException extends RuntimeException {
    /**
     * Constructor that accepts an error message.
     *
     * @param message Error message describing the cause of the exception.
     */
    public InvalidParameterException(String message) {
        super(message);
    }
}