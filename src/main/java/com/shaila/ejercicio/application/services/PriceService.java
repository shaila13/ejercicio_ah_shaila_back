package com.shaila.ejercicio.application.services;


import com.shaila.ejercicio.domain.ports.in.GetPricesInfoUseCase;
import com.shaila.ejercicio.infraestructure.dto.ResponsePriceDto;



public class PriceService implements GetPricesInfoUseCase {
    private final GetPricesInfoUseCase getPricesInfoUseCase;

    public PriceService(GetPricesInfoUseCase getPricesInfoUseCase) {
        this.getPricesInfoUseCase = getPricesInfoUseCase;
    }

    @Override
    public ResponsePriceDto getPricesInfo(Long brandId, Long productId, String starDate, String endDate) {
        return getPricesInfoUseCase.getPricesInfo(brandId, productId, starDate, endDate);
    }
}

