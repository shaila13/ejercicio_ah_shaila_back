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
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Price {
    /**
     * Brand ID.
     */
    Long brandId;

    /**
     * Start date when the price applies.
     */
    LocalDateTime startDate;

    /**
     * End date when the price applies.
     */
    LocalDateTime endDate;

    /**
     * Price list ID.
     */
    int priceList;

    /**
     * Product ID.
     */
    Long productId;

    /**
     * Priority of the price.
     */
    int priority;

    /**
     * Final selling price.
     */
    Double price;

    /**
     * Currency ISO.
     */
    String currency;
}
