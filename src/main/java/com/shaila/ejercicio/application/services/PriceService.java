package com.shaila.ejercicio.application.services;


import com.shaila.ejercicio.domain.ports.in.GetPricesInfoUseCase;
import com.shaila.ejercicio.infraestructure.dto.ResponsePriceDto;

import java.time.LocalDateTime;


/**
 * Implementación de la interfaz {@link GetPricesInfoUseCase}.
 * Esta clase actúa como un servicio para obtener información de precios.
 */
public class PriceService implements GetPricesInfoUseCase {
    private final GetPricesInfoUseCase getPricesInfoUseCase;

    /**
     * Constructor de la clase PriceService.
     *
     * @param getPricesInfoUseCase Implementación de GetPricesInfoUseCase a utilizar.
     */
    public PriceService(GetPricesInfoUseCase getPricesInfoUseCase) {
        this.getPricesInfoUseCase = getPricesInfoUseCase;
    }

    /**
     * Obtiene información de precios para un producto y marca específicos en una fecha dada.
     *
     * @param brandId         ID de la marca.
     * @param productId       ID del producto.
     * @param applicationDate Fecha de aplicación para obtener los precios.
     * @return {@link ResponsePriceDto} que contiene la información de precios.
     */
    @Override
    public ResponsePriceDto getPricesInfo(Long brandId, Long productId, LocalDateTime applicationDate) {
        return getPricesInfoUseCase.getPricesInfo(brandId, productId, applicationDate);
    }
}

