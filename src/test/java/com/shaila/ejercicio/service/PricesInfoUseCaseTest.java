package com.shaila.ejercicio.service;

import com.shaila.ejercicio.application.services.PriceService;
import com.shaila.ejercicio.application.usescases.GetPricesUseCaseImpl;
import com.shaila.ejercicio.domain.models.Price;
import com.shaila.ejercicio.domain.ports.out.PriceRepositoryPort;
import com.shaila.ejercicio.infraestructure.dto.ResponsePriceDto;
import com.shaila.ejercicio.infraestructure.exception.InvalidParameterException;
import com.shaila.ejercicio.infraestructure.exception.PriceNotFoundException;
import com.shaila.ejercicio.infraestructure.repositories.JpaPriceRepositoryAdapter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
class PricesInfoUseCaseTest {

	Long brandId = 1L;
	Long productId = 35455L;
	String starDate = "2020-06-14 00:00:00";
	String endDate = "2020-12-30 23:59:59";
	Price price ;
	Price price2 ;
	List<Price> priceList ;

	@MockBean(name = "priceRepositoryPort")
	PriceRepositoryPort priceRepositoryPort;

	@MockBean(name = "jpaPriceRepositoryAdapter")
	JpaPriceRepositoryAdapter jpaPriceRepositoryAdapter;
	@InjectMocks
	PriceService priceService;

	@InjectMocks
	GetPricesUseCaseImpl getPricesUseCase;

	@BeforeEach
	void setUp() {
		price = new Price(1L, LocalDateTime.now(), LocalDateTime.now().plusHours(1),
				1, 35455L, 1, 35.50, "EUR");
		price2 = new Price(1L, LocalDateTime.now(), LocalDateTime.now().plusHours(1),
				2, 35455L, 1, 90.50, "EUR");
		priceList = new ArrayList<>();
		priceList.add(price);
		priceList.add(price2);
		priceRepositoryPort = mock(PriceRepositoryPort.class);
		jpaPriceRepositoryAdapter = mock(JpaPriceRepositoryAdapter.class);
		getPricesUseCase = new GetPricesUseCaseImpl(priceRepositoryPort);
		priceService = new PriceService(getPricesUseCase);
	}

	@Test
	public void shouldReturnPricesWhenCalledWithValidParameters(){
		when(priceRepositoryPort.findByBrandIdAndProductIdDateApplication(any(),any(),any(),any())).thenReturn(priceList);

		ResponsePriceDto result = priceService.getPricesInfo(brandId, productId, starDate, endDate);
		assertNotNull(result);
		assertEquals(2, result.getPrices().size());
		assertEquals(35.50, result.getPrices().get(0).getPrice());

	}

	@Test
	public void shouldReturnPriceNotFoundExceptionWhenDoNotFindAnyPrices() {
		when(priceRepositoryPort.findByBrandIdAndProductIdDateApplication(anyLong(), anyLong(), any(), any()))
				.thenReturn(Collections.emptyList());
		assertThrows(PriceNotFoundException.class,
				() -> getPricesUseCase.getPricesInfo(1L, 35455L, "2024-06-14 00:00:00", "2024-12-30 23:59:59"));
	}

	@Test
	public void shouldReturnInvalidParameterExceptionWhenCalledWithNoValidDates() {
		when(priceRepositoryPort.findByBrandIdAndProductIdDateApplication(anyLong(), anyLong(), any(), any()))
				.thenReturn(priceList);
		assertThrows(InvalidParameterException.class,
				() -> getPricesUseCase.getPricesInfo(1L, 35455L, "aaaa", "aaaa"));
	}

	@Test
	public void shouldReturnValidLocalDateTimeWhenCalledWithValidStringDate() {
		LocalDateTime expectedDateTime = LocalDateTime.of(2020, 6, 14, 0, 0, 0);
		LocalDateTime resultDateTime = getPricesUseCase.convertStringToLocalDateTime("2020-06-14 00:00:00");
		assertEquals(expectedDateTime, resultDateTime);
	}


}
