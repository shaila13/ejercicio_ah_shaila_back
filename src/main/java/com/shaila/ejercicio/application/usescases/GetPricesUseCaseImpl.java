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
import java.util.Optional;


public class GetPricesUseCaseImpl implements GetPricesInfoUseCase {
    private final PriceRepositoryPort priceRepositoryPort;

    /**
     * Constructor de GetPricesUseCaseImpl.
     *
     * @param priceRepositoryPort Puerto para acceder a los precios.
     */
    public GetPricesUseCaseImpl(PriceRepositoryPort priceRepositoryPort) {
        this.priceRepositoryPort = priceRepositoryPort;
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
    public ResponsePriceDto getPricesInfo(Long brandId, Long productId, String applicationDate) {

            var optionalPrice = priceRepositoryPort.findByBrandIdAndProductIdDateApplication(brandId, productId,
                    getDate(applicationDate,"yyyy-MM-dd HH:mm:ss")).flatMap(list -> list.stream().findFirst());

            var price = optionalPrice.stream().findFirst().orElseThrow(() -> new PriceNotFoundException("No se encontraron precios para los parámetros proporcionados."));

            return new ResponsePriceDto(PriceDataAccessMapper.toPriceDto(price));

    }
    public static LocalDateTime getDate(String date, String pattern) {
        try {
            return LocalDateTime.parse(date, DateTimeFormatter.ofPattern(pattern));
        } catch (DateTimeParseException e) {
            throw new InvalidParameterException("Formato de fecha incorrecto. Se esperaba 'yyyy-MM-dd HH:mm:ss'.");
        }
    }

}

