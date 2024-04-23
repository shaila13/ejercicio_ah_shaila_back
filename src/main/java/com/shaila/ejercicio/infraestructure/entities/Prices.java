package com.shaila.ejercicio.infraestructure.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

/**
 * Clase de entidad que representa la tabla "PRICES" en la base de datos.
 * Contiene información sobre precios, como ID, producto, marca, fechas de inicio y fin, precio, lista de precios, prioridad y moneda.
 */
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "PRICES")
public class Prices  implements Serializable {

    static final long serialVersionUID = 1L;

    /**
     * ID único de la entrada de precios.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long pricesId;

    /**
     * ID del producto.
     */
    @NotNull
    Long productId;

    /**
     * ID de la marca.
     */
    @NotNull
    Long brandId;

    /**
     * Fecha de inicio de la aplicación del precio.
     */
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    LocalDateTime startDate;

    /**
     * Fecha de fin de la aplicación del precio.
     */
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    LocalDateTime endDate;

    /**
     * Precio.
     */
    double price;

    /**
     * Lista de precios.
     */
    int priceList;

    /**
     * Prioridad del precio.
     */
    int priority;

    /**
     * Moneda del precio.
     */
    String curr;
    
}
