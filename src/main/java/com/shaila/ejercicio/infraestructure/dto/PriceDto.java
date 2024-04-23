package com.shaila.ejercicio.infraestructure.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Clase DTO (Data Transfer Object) que representa un precio.
 * Contiene información sobre el producto, la marca, la lista de precios, la fecha de inicio, la fecha de fin y el precio.
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PriceDto implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Identificador código de producto.
     */
    Long productId;

    /**
     * Identificador de la cadena.
     */
    Long brandId;

    /**
     * Identificador de la tarifa de precios aplicable.
     */
    int priceList;

    /**
     * Fecha de inicio en el que aplica el precio tarifa indicado.
     */
    LocalDateTime startDate;

    /**
     * Fecha de fin en el que aplica el precio tarifa indicado.
     */
    LocalDateTime endDate;

    /**
     * Precio final de venta.
     */
    Double price;

}



