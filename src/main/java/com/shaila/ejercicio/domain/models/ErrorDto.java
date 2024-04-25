package com.shaila.ejercicio.domain.models;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

/**
 * Clase que representa un objeto de transferencia de datos (DTO) para representar errores.
 * Este DTO contiene información sobre el estado HTTP, el mensaje de error y la marca de tiempo del error.
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ErrorDto {

      /**
       * Estado HTTP del error.
       */
      HttpStatus status;

      /**
       * Mensaje descriptivo del error.
       */
      String message;

      /**
       * Marca de tiempo en la que ocurrió el error.
       */
      LocalDateTime timestamp;

}
