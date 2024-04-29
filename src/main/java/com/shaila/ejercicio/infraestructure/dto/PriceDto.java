package com.shaila.ejercicio.infraestructure.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO (Data Transfer Object) class representing a price.
 * Contains information about the product, brand, price list, start date, end date, and price.
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PriceDto implements Serializable {

    private static final long serialVersionUID = 1L;

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
     * Start date when the price list applies.
     */
    LocalDateTime startDate;

    /**
     * End date when the price list applies.
     */
    LocalDateTime endDate;

    /**
     * Final selling price.
     */
    Double price;

}



