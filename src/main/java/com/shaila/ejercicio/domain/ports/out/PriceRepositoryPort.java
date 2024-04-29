package com.shaila.ejercicio.domain.ports.out;

import com.shaila.ejercicio.domain.models.Price;

import java.time.LocalDateTime;
import java.util.Optional;
/**
 * Interface defining methods for accessing price data in the data access layer.
 * Implementations of this interface provide the logic for retrieving prices.
 */
public interface PriceRepositoryPort {
   /**
    * Finds price information for a specific brand, product, and application date.
    *
    * @param brandId         The brand ID.
    * @param productId       The product ID.
    * @param applicationDate The application date for which prices are sought.
    * @return An {@link Optional} containing the price information if prices are found for the provided
    *         parameters, or an empty {@link Optional} if no prices are found.
    */
   Optional<Price> findByBrandIdAndProductIdDateApplication(Long brandId, Long productId, LocalDateTime applicationDate);

}
