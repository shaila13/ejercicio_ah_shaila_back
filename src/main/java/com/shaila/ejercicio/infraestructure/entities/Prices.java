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
 * Entity class representing the "PRICES" table in the database.
 * It contains information about prices, such as ID, product, brand, start and end dates, price, price list, priority, and currency.
 */
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "PRICES")
public class Prices implements Serializable {

    static final long serialVersionUID = 1L;

    /**
     * Unique ID of the price entry.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long pricesId;

    /**
     * ID of the product.
     */
    @NotNull
    Long productId;

    /**
     * ID of the brand.
     */
    @NotNull
    Long brandId;

    /**
     * Start date of the price application.
     */
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    LocalDateTime startDate;

    /**
     * End date of the price application.
     */
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    LocalDateTime endDate;

    /**
     * Price.
     */
    double price;

    /**
     * Price list.
     */
    int priceList;

    /**
     * Price priority.
     */
    int priority;

    /**
     * Price currency.
     */
    String curr;

}
