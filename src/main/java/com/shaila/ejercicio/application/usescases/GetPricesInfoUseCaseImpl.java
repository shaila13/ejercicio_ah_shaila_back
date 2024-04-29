package com.shaila.ejercicio.application.usescases;


import com.shaila.ejercicio.domain.ports.in.GetPricesInfoUseCase;
import com.shaila.ejercicio.domain.ports.out.PriceRepositoryPort;
import com.shaila.ejercicio.domain.models.ResponsePrice;
import com.shaila.ejercicio.infraestructure.exception.PriceNotFoundException;
import com.shaila.ejercicio.infraestructure.mappers.PriceDataAccessMapper;

import java.time.LocalDateTime;


public class GetPricesInfoUseCaseImpl implements GetPricesInfoUseCase {
    private final PriceRepositoryPort priceRepositoryPort;

    /**
     * Constructor for GetPricesUseCaseImpl.
     *
     * @param priceRepositoryPort Port to access prices.
     */
    public GetPricesInfoUseCaseImpl(PriceRepositoryPort priceRepositoryPort) {
        this.priceRepositoryPort = priceRepositoryPort;
    }
    /**
     * Retrieves price information for a specific product and brand on a given date.
     *
     * @param brandId         Brand ID.
     * @param productId       Product ID.
     * @param applicationDate Date of application to retrieve prices.
     * @return {@link ResponsePrice} containing price information.
     */
    @Override
    public ResponsePrice getPricesInfo(Long brandId, Long productId, LocalDateTime applicationDate) {
            return new ResponsePrice(PriceDataAccessMapper.toPriceDto(priceRepositoryPort.findByBrandIdAndProductIdDateApplication(brandId,
                    productId,applicationDate).orElseThrow(() ->
                    new PriceNotFoundException("No prices were found for the provided parameters."))));

    }

}

