package com.shaila.ejercicio.infraestructure.exception;
/**
 * Excepción personalizada para indicar que no se encontró un precio.
 * Se lanza cuando se busca un precio en la base de datos y no se encuentra ninguno para los parámetros proporcionados.
 */
public class PriceNotFoundException extends RuntimeException {
    /**
     * Constructor que acepta un mensaje de error.
     *
     * @param message Mensaje de error que describe la causa de la excepción.
     */
    public PriceNotFoundException(String message) {
        super(message);
    }
}

