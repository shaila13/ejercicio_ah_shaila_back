package com.shaila.ejercicio.infraestructure.mappers;

import com.shaila.ejercicio.domain.models.Price;
import com.shaila.ejercicio.infraestructure.entities.Prices;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.*;

class PriceDataAccessMapperTest {

    private static final Long PRICE_ID = 1L;
    private static final Long BRAND_ID = 1L;
    private static final Long PRODUCT_ID = 35455L;
    private static final double PRICE = 35.50;
    private static final int PRICE_LIST = 1;
    private static final String CURR = "EUR";
    private static final int PRIORITY = 1;
    private  Prices prices;
    private Price price ;

    @BeforeEach
    void setUp() {
        price = new Price(PRODUCT_ID, BRAND_ID,PRICE_LIST, LocalDateTime.now(), LocalDateTime.now().plusHours(1),
                PRICE, PRIORITY, CURR);
        prices = new Prices(PRICE_ID,PRODUCT_ID, BRAND_ID, LocalDateTime.now(), LocalDateTime.now().plusHours(1),
                PRICE,  PRICE_LIST, PRIORITY, CURR);
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