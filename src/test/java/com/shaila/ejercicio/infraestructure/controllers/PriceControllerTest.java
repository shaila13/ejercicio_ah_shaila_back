package com.shaila.ejercicio.infraestructure.controllers;

import com.shaila.ejercicio.domain.models.Price;
import com.shaila.ejercicio.domain.models.ResponsePrice;
import com.shaila.ejercicio.domain.ports.in.GetPricesInfoUseCase;
import com.shaila.ejercicio.infraestructure.dto.PriceDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class PriceControllerTest {

    private static final String BRAND_ID = "1";
    private static final String PRODUCT_ID = "35455";
    private static final String APPLICATION_DATE = "2024-05-01 12:00:00";
    private static final double PRICE = 35.50;
    private PriceDto priceDto;
    @Mock
    private GetPricesInfoUseCase getPricesInfoUseCase;

    @InjectMocks
    private PriceController priceController;

    @BeforeEach
    void setUp() {
        priceDto = new PriceDto(35455L, 1L, 1, LocalDateTime.now(), LocalDateTime.now(),
                PRICE);
        getPricesInfoUseCase = mock(GetPricesInfoUseCase.class);
        priceController = new PriceController(getPricesInfoUseCase);
    }
    @Test
    void shouldGetInfoPrices() {

        ResponsePrice expectedResponse = new ResponsePrice(priceDto);

        when(getPricesInfoUseCase.getPricesInfo(anyLong(), anyLong(), any()))
                .thenReturn(expectedResponse);

        ResponseEntity<ResponsePrice> responseEntity = priceController.getInfoPrices(
                BRAND_ID, PRODUCT_ID, APPLICATION_DATE);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(expectedResponse, responseEntity.getBody());
    }
}