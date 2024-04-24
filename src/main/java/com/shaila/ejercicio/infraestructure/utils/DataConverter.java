package com.shaila.ejercicio.infraestructure.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Optional;

import com.shaila.ejercicio.infraestructure.exception.InvalidParameterException;

public class DataConverter {

    /**
     * Valida si el valor pasado es numérico.
     *
     * @param valor El valor a validar.
     * @return El valor validado si es numérico.
     * @throws InvalidParameterException Si el valor es nulo o no es numérico.
     */
	public static Long validateNumericParameters(String valor) {
		return Optional.ofNullable(valor)
                .filter(v -> v.matches("-?\\d+"))
                .map(Long::valueOf)
                .orElseThrow(() -> new InvalidParameterException("El parámetro debe ser numérico."));
	}

	/**
     * Parsea una cadena a LocalDateTime usando el patrón especificado.
     *
     * @param date    Cadena de fecha a parsear.
     * @param pattern Patrón de formato de fecha.
     * @return Objeto LocalDateTime parseado.
     */
	public static LocalDateTime getDate(String date, String pattern) {
        try {
            return LocalDateTime.parse(date, DateTimeFormatter.ofPattern(pattern));
        } catch (DateTimeParseException e) {
            throw new InvalidParameterException("Formato de fecha incorrecto. Se esperaba '" + pattern + "'.");
        }
    }

}
