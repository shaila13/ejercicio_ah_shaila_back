package com.shaila.ejercicio.infraestructure.repositories;

import com.shaila.ejercicio.domain.models.Price;
import com.shaila.ejercicio.infraestructure.entities.Prices;
import com.shaila.ejercicio.infraestructure.mappers.PriceDataAccessMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class JpaPriceRepositoryAdapterTest {

    private static final Long PRICE_ID = 1L;
    private static final Long BRAND_ID = 1L;
    private static final Long PRODUCT_ID = 35455L;
    private static final LocalDateTime APPLICATION_DATE = LocalDateTime.of(2024, 5, 1, 12, 0);
    private static final double PRICE = 35.50;
    private static final int PRICE_LIST = 1;
    private static final String CURR = "EUR";
    private static final int PRIORITY = 1;
    private Price price;
    private Prices priceEntity;
    @Mock
    private JpaPriceRepository jpaPriceRepository;

    @Mock
    private PriceDataAccessMapper priceDataAccessMapper;

    @InjectMocks
    private JpaPriceRepositoryAdapter jpaPriceRepositoryAdapter;


    @BeforeEach
    void setUp() {
        price = new Price(PRODUCT_ID, BRAND_ID, PRICE_LIST, LocalDateTime.now(), LocalDateTime.now(),
                PRICE, PRIORITY, CURR);
        priceEntity = new Prices(PRICE_ID,PRODUCT_ID, BRAND_ID, LocalDateTime.now(), LocalDateTime.now(),PRICE,
                PRICE_LIST, PRIORITY, CURR);
        jpaPriceRepository = mock(JpaPriceRepository.class);
        priceDataAccessMapper = mock(PriceDataAccessMapper.class);
        jpaPriceRepositoryAdapter = new JpaPriceRepositoryAdapter(jpaPriceRepository, priceDataAccessMapper);
    }

    @Test
    void shouldFindByBrandIdAndProductIdDateApplication() {
        when(jpaPriceRepository.findByBrandIdAndProductIdAndApplicationDateOrderByPriorityDesc(anyLong(), anyLong(), any()))
                .thenReturn(Optional.ofNullable(priceEntity));

        Optional<Price> result = jpaPriceRepositoryAdapter.findByBrandIdAndProductIdDateApplication(BRAND_ID, PRODUCT_ID,
                APPLICATION_DATE);

        assertNotNull(result);

        assertEquals(price.getPrice(), result.get().getPrice());
        assertEquals(price.getProductId(), result.get().getProductId());
        assertEquals(price.getBrandId(), result.get().getBrandId());
        assertEquals(price.getPriority(), result.get().getPriority());
        assertEquals(price.getPriceList(), result.get().getPriceList());
        assertEquals(price.getStartDate().truncatedTo(ChronoUnit.SECONDS), result.get().getStartDate().truncatedTo(
                ChronoUnit.SECONDS));
        assertEquals(price.getEndDate().truncatedTo(ChronoUnit.SECONDS), result.get().getEndDate().truncatedTo(
                ChronoUnit.SECONDS));
    }
}