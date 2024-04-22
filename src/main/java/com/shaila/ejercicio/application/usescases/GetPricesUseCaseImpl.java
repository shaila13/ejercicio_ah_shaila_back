package com.shaila.ejercicio.application.usescases;


import com.shaila.ejercicio.domain.models.Price;
import com.shaila.ejercicio.domain.ports.in.GetPricesInfoUseCase;
import com.shaila.ejercicio.domain.ports.out.PriceRepositoryPort;
import com.shaila.ejercicio.infraestructure.dto.ResponsePriceDto;
import com.shaila.ejercicio.infraestructure.exception.InvalidParameterException;
import com.shaila.ejercicio.infraestructure.exception.PriceNotFoundException;
import com.shaila.ejercicio.infraestructure.mappers.PriceDataAccessMapper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.stream.Collectors;


public class GetPricesUseCaseImpl implements GetPricesInfoUseCase {
    private final PriceRepositoryPort priceRepositoryPort;

    public GetPricesUseCaseImpl(PriceRepositoryPort priceRepositoryPort) {
        this.priceRepositoryPort = priceRepositoryPort;
    }

    @Override
    public ResponsePriceDto getPricesInfo(Long brandId,Long productId, String starDate, String endDate) {

        try {

            List<Price> priceList = priceRepositoryPort.findByBrandIdAndProductIdDateApplication(brandId, productId,
                    convertStringToLocalDateTime(starDate), convertStringToLocalDateTime(endDate));

            if (priceList.isEmpty()) {
                throw new PriceNotFoundException("No se encontraron precios para los parámetros proporcionados.");
            }

            return new ResponsePriceDto(priceList.stream()
                    .map(PriceDataAccessMapper::toPriceDto)
                    .collect(Collectors.toList()));
        } catch (DateTimeParseException e) {
            throw new InvalidParameterException("Formato de fecha incorrecto. Se esperaba 'yyyy-MM-dd HH:mm:ss'.");
        }
    }

    public LocalDateTime convertStringToLocalDateTime(String stringDate) {
        return LocalDateTime.parse(stringDate, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
}

