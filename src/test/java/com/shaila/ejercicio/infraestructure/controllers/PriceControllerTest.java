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

    String brandId = "1";
    String productId = "35455";
    String applicationDate = "2024-05-01 12:00:00";
    PriceDto priceDto;
    @Mock
    private GetPricesInfoUseCase getPricesInfoUseCase;

    @InjectMocks
    private PriceController priceController;

    @BeforeEach
    void setUp() {
        priceDto = new PriceDto(35455L, 1L, 1, LocalDateTime.now(), LocalDateTime.now(),
                35.50);
        getPricesInfoUseCase = mock(GetPricesInfoUseCase.class);
        priceController = new PriceController(getPricesInfoUseCase);
    }
    @Test
    void shouldGetInfoPrices() {

        ResponsePrice expectedResponse = new ResponsePrice(priceDto);

        when(getPricesInfoUseCase.getPricesInfo(anyLong(), anyLong(), any()))
                .thenReturn(expectedResponse);

        ResponseEntity<ResponsePrice> responseEntity = priceController.getInfoPrices(
                brandId, productId, applicationDate);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(expectedResponse, responseEntity.getBody());
    }
}