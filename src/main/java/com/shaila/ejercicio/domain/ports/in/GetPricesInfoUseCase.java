package com.shaila.ejercicio.domain.ports.in;

import com.shaila.ejercicio.domain.models.ResponsePriceDto;

import java.time.LocalDateTime;

/**
 * Interfaz que define el caso de uso para obtener información de precios.
 */

public interface GetPricesInfoUseCase {
    /**
     * Método para obtener información de precios para una marca, producto y fecha de aplicación específicos.
     *
     * @param brandId        ID de la marca.
     * @param productId      ID del producto.
     * @param applicationDate Fecha de aplicación para la cual se buscan los precios.
     * @return DTO de respuesta que contiene la información de precios.
     */
    ResponsePriceDto getPricesInfo(Long brandId, Long productId, LocalDateTime applicationDate);
}
