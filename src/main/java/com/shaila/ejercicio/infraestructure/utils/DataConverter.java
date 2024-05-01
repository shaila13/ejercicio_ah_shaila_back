package com.shaila.ejercicio.infraestructure.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Optional;

import com.shaila.ejercicio.infraestructure.exception.InvalidParameterException;

public class DataConverter {

    /**
     * Validates if the passed value is numeric.
     *
     * @param value The value to validate.
     * @return The validated value if it is numeric.
     * @throws InvalidParameterException If the value is null or not numeric.
     */
	public static Long validateNumericParameters(String value) {
		return Optional.ofNullable(value)
                .filter(v -> v.matches("-?\\d+"))
                .map(Long::valueOf)
                .orElseThrow(() -> new InvalidParameterException("The parameter must be numeric."));
	}

    /**
     * Parses a string to LocalDateTime using the specified pattern.
     *
     * @param date    Date string to parse.
     * @param pattern Date format pattern.
     * @return Parsed LocalDateTime object.
     * @throws InvalidParameterException If the provided date string is null or has an incorrect format.
     */
	public static LocalDateTime getDate(String date, String pattern) {
        if (date == null) {
            throw new InvalidParameterException("Date cannot be null.");
        }
        try {
            return LocalDateTime.parse(date, DateTimeFormatter.ofPattern(pattern));
        } catch (DateTimeParseException e) {
            throw new InvalidParameterException("Incorrect date format. Expected '" + pattern + "'.");
        }
    }

}
