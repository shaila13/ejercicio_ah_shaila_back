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
     * Identificador de la cadena.
     */
    Long brandId;

    /**
     * Fecha de inicio en el que aplica el precio tarifa indicado.
     */
    LocalDateTime startDate;

    /**
     * Fecha de fin en el que aplica el precio tarifa indicado.
     */
    LocalDateTime endDate;

    /**
     * Identificador de la tarifa de precios aplicable.
     */
    int priceList;

    /**
     * Identificador código de producto.
     */
    Long productId;

    /**
     * Desambiguador de aplicación de precios.
     */
    int priority;

    /**
     * Precio final de venta.
     */
    Double price;

    /**
     * Iso de la moneda.
     */
    String currency;


    

}
