package com.shaila.ejercicio.domain.models;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

/**
 * Class representing a price model.
 * Contains information about the brand, start and end dates, price list, product ID, priority, price, and currency.
 */

@Getter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Price {

    /**
     * Product ID.
     */
    Long productId;


    /**
     * Brand ID.
     */
    Long brandId;

    /**
     * Price list ID.
     */
    int priceList;

    /**
     * Start date when the price applies.
     */
    LocalDateTime startDate;

    /**
     * End date when the price applies.
     */
    LocalDateTime endDate;

    /**
     * Final selling price.
     */
    Double price;

    /**
     * Priority of the price.
     */
    int priority;


    /**
     * Currency ISO.
     */
    String currency;
}
