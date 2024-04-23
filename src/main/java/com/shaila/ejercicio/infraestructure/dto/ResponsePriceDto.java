package com.shaila.ejercicio.infraestructure.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.List;

/**
 * Clase DTO (Data Transfer Object) que representa la respuesta de precios.
 * Contiene una lista de objetos {@link PriceDto} que representan los precios.
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ResponsePriceDto implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * Lista de precios.
     */
    List<PriceDto> prices;

}
