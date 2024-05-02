package com.shaila.ejercicio.infraestructure.utils;

import com.shaila.ejercicio.infraestructure.exception.InvalidParameterException;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class DataConverterTest {

    private static final String NUMERIC_VALUE = "12345";
    private static final String NON_NUMERIC_VALUE = "abc";
    private static final String DATE = "2024-05-01 12:00:00";
    private static final String DATE_INCORRECT_FORMAT = "01-05-2024 12:00:00";
    private static final String DATE_INVALID_TIME = "2024-05-01 25:00:00";
    private static final String DATE_NULL = null;
    private static final String PATTERN = "yyyy-MM-dd HH:mm:ss";

    @Test
    public void shouldReturnValidLongWhenGivenNumericValue() {
        var result = DataConverter.validateNumericParameters(NUMERIC_VALUE);
        assertEquals(12345L, result);
    }
    @Test
    public void shouldThrowInvalidParameterExceptionWhenGivenNonNumericValue() {
        assertThrows(InvalidParameterException.class, () -> DataConverter.validateNumericParameters(NON_NUMERIC_VALUE));
    }

    @Test
    public void shouldReturnParsedLocalDateTime() {
        LocalDateTime result = DataConverter.getDate(DATE, PATTERN);
        assertEquals(LocalDateTime.of(2024, 5, 1, 12, 0, 0), result);
    }

    @Test
    public void shouldThrowInvalidParameterExceptionForIncorrectDateFormat() {
        assertThrows(InvalidParameterException.class, () -> DataConverter.getDate(DATE_INCORRECT_FORMAT, PATTERN));
    }

    @Test
    public void shouldThrowInvalidParameterExceptionForInvalidDateTime() {
        assertThrows(InvalidParameterException.class, () -> DataConverter.getDate(DATE_INVALID_TIME, PATTERN));
    }

    @Test
    public void shouldThrowInvalidParameterExceptionForNullDate() {
        assertThrows(InvalidParameterException.class, () -> DataConverter.getDate(DATE_NULL, PATTERN));
    }
}