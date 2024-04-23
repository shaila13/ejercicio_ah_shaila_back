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
     * ID del producto.
     */
    Long productId;

    /**
     * ID de la marca.
     */
    Long brandId;

    /**
     * Lista de precios.
     */
    int priceList;

    /**
     * Fecha de inicio.
     */
    LocalDateTime startDate;

    /**
     * Fecha de fin.
     */
    LocalDateTime endDate;

    /**
     * Precio.
     */
    Double price;

}
