package com.shaila.ejercicio.infraestructure.utils;

import com.shaila.ejercicio.infraestructure.exception.InvalidParameterException;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class DataConverterTest {

    String numericValue = "12345";
    String nonNumericValue = "abc";
    String date = "2024-05-01 12:00:00";
    String dateIncorrectFormat = "01-05-2024 12:00:00";
    String dateInvalidTime = "2024-05-01 25:00:00";
    String dateNull = null;
    String pattern = "yyyy-MM-dd HH:mm:ss";

    @Test
    public void shouldReturnValidLongWhenGivenNumericValue() {
        var result = DataConverter.validateNumericParameters(numericValue);
        assertEquals(12345L, result);
    }
    @Test
    public void shouldThrowInvalidParameterExceptionWhenGivenNonNumericValue() {
        assertThrows(InvalidParameterException.class, () -> DataConverter.validateNumericParameters(nonNumericValue));
    }

    @Test
    public void shouldReturnParsedLocalDateTime() {
        LocalDateTime result = DataConverter.getDate(date, pattern);
        assertEquals(LocalDateTime.of(2024, 5, 1, 12, 0, 0), result);
    }

    @Test
    public void shouldThrowInvalidParameterExceptionForIncorrectDateFormat() {
        assertThrows(InvalidParameterException.class, () -> DataConverter.getDate(dateIncorrectFormat, pattern));
    }

    @Test
    public void shouldThrowInvalidParameterExceptionForInvalidDateTime() {
        assertThrows(InvalidParameterException.class, () -> DataConverter.getDate(dateInvalidTime, pattern));
    }

    @Test
    public void shouldThrowInvalidParameterExceptionForNullDate() {
        assertThrows(InvalidParameterException.class, () -> DataConverter.getDate(dateNull, pattern));
    }
}