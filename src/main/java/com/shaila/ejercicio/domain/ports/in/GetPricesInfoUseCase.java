package com.shaila.ejercicio.domain.ports.in;

import com.shaila.ejercicio.infraestructure.dto.ResponsePriceDto;


public interface GetPricesInfoUseCase {
    ResponsePriceDto getPricesInfo(Long brandId, Long productId, String aplicationDate);
}
