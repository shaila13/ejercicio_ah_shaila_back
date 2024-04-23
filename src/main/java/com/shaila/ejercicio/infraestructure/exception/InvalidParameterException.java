package com.shaila.ejercicio.infraestructure.exception;
/**
 * Excepción personalizada para indicar un parámetro inválido.
 * Se lanza cuando se detecta que un parámetro proporcionado es inválido o está en un formato incorrecto.
 */
public class InvalidParameterException extends RuntimeException {
    /**
     * Constructor que acepta un mensaje de error.
     *
     * @param message Mensaje de error que describe la causa de la excepción.
     */
    public InvalidParameterException(String message) {
        super(message);
    }
}

