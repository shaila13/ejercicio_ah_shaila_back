package com.shaila.ejercicio.domain.models;

import com.shaila.ejercicio.infraestructure.dto.PriceDto;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

/**
 * Clase DTO (Data Transfer Object) que representa la respuesta de precios.
 * Contiene una lista de objetos {@link PriceDto} que representan los precios.
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ResponsePrice implements Serializable {

    private static final long serialVersionUID = 1L;
    PriceDto price;

}