package com.shaila.ejercicio.domain.ports.in;

import com.shaila.ejercicio.domain.models.ResponsePrice;

import java.time.LocalDateTime;

/**
 * Interface defining the use case for retrieving price information.
 */

public interface GetPricesInfoUseCase {
    /**
     * Method to retrieve price information for a specific brand, product, and application date.
     *
     * @param brandId         Brand ID.
     * @param productId       Product ID.
     * @param applicationDate Date of application for which prices are sought.
     * @return Response DTO containing price information.
     */
    ResponsePrice getPricesInfo(Long brandId, Long productId, LocalDateTime applicationDate);
}
