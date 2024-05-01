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
    Long brandId = 1L;
    Long productId = 35455L;
    LocalDateTime applicationDate = LocalDateTime.of(2024, 5, 1, 12, 0);
    Price price;
    Prices priceEntity;
    @Mock
    private JpaPriceRepository jpaPriceRepository;

    @Mock
    private PriceDataAccessMapper priceDataAccessMapper;

    @InjectMocks
    private JpaPriceRepositoryAdapter jpaPriceRepositoryAdapter;


    @BeforeEach
    void setUp() {
        price = new Price(productId, brandId, 1, LocalDateTime.now(), LocalDateTime.now(),
                35.50, 1, "EUR");
        priceEntity = new Prices(1L,productId, brandId, LocalDateTime.now(), LocalDateTime.now(),35.50,
                1, 1, "EUR");
        jpaPriceRepository = mock(JpaPriceRepository.class);
        priceDataAccessMapper = mock(PriceDataAccessMapper.class);
        jpaPriceRepositoryAdapter = new JpaPriceRepositoryAdapter(jpaPriceRepository, priceDataAccessMapper);
    }

    @Test
    void shouldFindByBrandIdAndProductIdDateApplication() {
        when(jpaPriceRepository.findByBrandIdAndProductIdAndApplicationDateOrderByPriorityDesc(anyLong(), anyLong(), any()))
                .thenReturn(Optional.ofNullable(priceEntity));

        Optional<Price> result = jpaPriceRepositoryAdapter.findByBrandIdAndProductIdDateApplication(brandId, productId, applicationDate);

        assertNotNull(result);

        assertEquals(price.getPrice(), result.get().getPrice());
        assertEquals(price.getProductId(), result.get().getProductId());
        assertEquals(price.getBrandId(), result.get().getBrandId());
        assertEquals(price.getPriority(), result.get().getPriority());
        assertEquals(price.getPriceList(), result.get().getPriceList());
        assertEquals(price.getStartDate().truncatedTo(ChronoUnit.SECONDS), result.get().getStartDate().truncatedTo(ChronoUnit.SECONDS));
        assertEquals(price.getEndDate().truncatedTo(ChronoUnit.SECONDS), result.get().getEndDate().truncatedTo(ChronoUnit.SECONDS));
    }
}