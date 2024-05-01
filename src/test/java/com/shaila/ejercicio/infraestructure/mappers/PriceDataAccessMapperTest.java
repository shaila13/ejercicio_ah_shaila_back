package com.shaila.ejercicio.infraestructure.mappers;

import com.shaila.ejercicio.domain.models.Price;
import com.shaila.ejercicio.infraestructure.entities.Prices;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.*;

class PriceDataAccessMapperTest {
    Long brandId = 1L;
    Long productId = 35455L;
    Prices prices;
    Price price ;

    @BeforeEach
    void setUp() {
        price = new Price(productId, brandId,1, LocalDateTime.now(), LocalDateTime.now().plusHours(1),
                35.50, 1, "EUR");
        prices = new Prices(1L,productId, brandId, LocalDateTime.now(), LocalDateTime.now().plusHours(1),
                35.50,  1, 1, "EUR");
    }


    @Test
    public void shouldReturnPriceWhenCalledToDomainModel() {
        var result = PriceDataAccessMapper.toDomainModel(prices);

        assertEquals(prices.getBrandId(), result.getBrandId());
        assertEquals(prices.getProductId(), result.getProductId());
        assertEquals(prices.getPrice(), result.getPrice());
        assertEquals(prices.getPriority(), result.getPriority());
    }

    @Test
    public void shouldReturnPriceDtoWhenCalledToPriceDto() {
        var result = PriceDataAccessMapper.toPriceDto(price);

        assertEquals(prices.getBrandId(), result.getBrandId());
        assertEquals(prices.getProductId(), result.getProductId());
        assertEquals(prices.getPrice(), result.getPrice());
        assertEquals(prices.getPriceList(), result.getPriceList());
        assertEquals(prices.getStartDate().truncatedTo(ChronoUnit.SECONDS), result.getStartDate().truncatedTo(ChronoUnit.SECONDS));
        assertEquals(prices.getEndDate().truncatedTo(ChronoUnit.SECONDS), result.getEndDate().truncatedTo(ChronoUnit.SECONDS));


    }
}