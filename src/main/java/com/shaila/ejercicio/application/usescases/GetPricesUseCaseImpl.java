package com.shaila.ejercicio.application.usescases;


import com.shaila.ejercicio.domain.models.Price;
import com.shaila.ejercicio.domain.ports.in.GetPricesInfoUseCase;
import com.shaila.ejercicio.domain.ports.out.PriceRepositoryPort;
import com.shaila.ejercicio.infraestructure.dto.PriceDto;
import com.shaila.ejercicio.infraestructure.dto.ResponsePriceDto;
import com.shaila.ejercicio.infraestructure.mappers.PriceDataAccessMapper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;


public class GetPricesUseCaseImpl implements GetPricesInfoUseCase {
    private final PriceRepositoryPort priceRepositoryPort;

    public GetPricesUseCaseImpl(PriceRepositoryPort priceRepositoryPort) {
        this.priceRepositoryPort = priceRepositoryPort;
    }

    @Override
    public ResponsePriceDto getPricesInfo(Long brandId,Long productId, String starDate, String endDate) {

      List<Price> priceList = priceRepositoryPort.findByBrandIdAndProductIdDateApplication(brandId,
              productId, convertStringToLocalDateTime(starDate),convertStringToLocalDateTime(endDate));
        return new ResponsePriceDto(priceList.stream()
                .map(PriceDataAccessMapper::toPriceDto)
                .collect(Collectors.toList()));
    }

    public LocalDateTime convertStringToLocalDateTime(String stringDate) {
        return LocalDateTime.parse(stringDate, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
}

