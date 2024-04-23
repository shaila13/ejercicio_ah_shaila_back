package com.shaila.ejercicio.domain.models;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
/**
 * Clase que representa un modelo de precio.
 * Contiene información sobre la marca, fechas de inicio y fin, lista de precios, ID del producto, prioridad, precio y moneda.
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Price {

    /**
     * ID de la marca.
     */
    Long brandId;

    /**
     * Fecha de inicio del precio.
     */
    LocalDateTime startDate;

    /**
     * Fecha de fin del precio.
     */
    LocalDateTime endDate;

    /**
     * Lista de precios.
     */
    int priceList;

    /**
     * ID del producto.
     */
    Long productId;

    /**
     * Prioridad del precio.
     */
    int priority;

    /**
     * Precio.
     */
    Double price;

    /**
     * Moneda del precio.
     */
    String currency;


    

}
