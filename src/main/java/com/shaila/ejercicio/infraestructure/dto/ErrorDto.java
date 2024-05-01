package com.shaila.ejercicio.infraestructure.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;


/**
 * Class representing a Data Transfer Object (DTO) for representing errors.
 * This DTO contains information about the HTTP status, error message, and timestamp of the error.
 */
@AllArgsConstructor
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ErrorDto {

      /**
       * HTTP status of the error.
       */
      HttpStatus status;

      /**
       * Descriptive message of the error.
       */
      String message;

      /**
       * Timestamp when the error occurred.
       */
      LocalDateTime timestamp;

}