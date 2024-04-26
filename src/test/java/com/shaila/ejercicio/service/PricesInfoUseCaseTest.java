package com.shaila.ejercicio.service;

import com.shaila.ejercicio.application.usescases.GetPricesInfoUseCaseImpl;
import com.shaila.ejercicio.domain.models.Price;
import com.shaila.ejercicio.domain.ports.out.PriceRepositoryPort;
import com.shaila.ejercicio.infraestructure.dto.PriceDto;
import com.shaila.ejercicio.domain.models.ResponsePrice;
import com.shaila.ejercicio.infraestructure.exception.InvalidParameterException;
import com.shaila.ejercicio.infraestructure.exception.PriceNotFoundException;
import com.shaila.ejercicio.infraestructure.repositories.JpaPriceRepositoryAdapter;
import com.shaila.ejercicio.infraestructure.utils.DataConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDateTime;

import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class PricesInfoUseCaseTest {

	Long brandId = 1L;
	Long productId = 35455L;
	String brandIdWrong = null;
	String productIdWrong = null;

	String applicationDate = "2020-06-14 00:00:00";
	String applicationDateWrong = "2020-06-14-00:00:00";
	Price price ;
	Price price2 ;
	PriceDto priceDto;
	List<Price> priceList ;

	ResponsePrice responsePriceDto;
	@MockBean(name = "priceRepositoryPort")
	PriceRepositoryPort priceRepositoryPort;

	@MockBean(name = "jpaPriceRepositoryAdapter")
	JpaPriceRepositoryAdapter jpaPriceRepositoryAdapter;

	@InjectMocks
	GetPricesInfoUseCaseImpl getPricesUseCase;

	@BeforeEach
	void setUp() {
		price = new Price(brandId, LocalDateTime.now(), LocalDateTime.now().plusHours(1),
				1, productId, 1, 35.50, "EUR");
		price2 = new Price(brandId, LocalDateTime.now(), LocalDateTime.now().plusHours(1),
				2, productId, 0, 25.45, "EUR");

		priceDto = new PriceDto(brandId,productId,1,  LocalDateTime.now(), LocalDateTime.now().plusHours(1),
				35.50);
		priceList = Arrays.asList(price,price2);
		responsePriceDto = new ResponsePrice(priceDto);
		priceRepositoryPort = mock(PriceRepositoryPort.class);
		jpaPriceRepositoryAdapter = mock(JpaPriceRepositoryAdapter.class);
		getPricesUseCase = new GetPricesInfoUseCaseImpl(priceRepositoryPort);
	}

	@Test
	public void shouldReturnPricesWhenCalledWithValidParameters(){
		when(priceRepositoryPort.findByBrandIdAndProductIdDateApplication(any(), any(), any()))
				.thenReturn(Optional.of(Collections.singletonList(price)));
		ResponsePrice result = getPricesUseCase.getPricesInfo(brandId, productId, DataConverter.getDate(applicationDate, "yyyy-MM-dd HH:mm:ss") );
		assertNotNull(result);
		assertNotNull(result.getPrice());
		assertEquals(35.50, result.getPrice().getPrice());
		verify(priceRepositoryPort, times(1))
				.findByBrandIdAndProductIdDateApplication(brandId, productId, LocalDateTime.parse(applicationDate, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

	}

	@Test
	public void shouldReturnPriceNotFoundExceptionWhenDoNotFindAnyPrices() {
		when(priceRepositoryPort.findByBrandIdAndProductIdDateApplication(anyLong(), anyLong(), any()))
				.thenReturn(Optional.empty());
		assertThrows(PriceNotFoundException.class,
				() -> getPricesUseCase.getPricesInfo(brandId, productId, DataConverter.getDate(applicationDate, "yyyy-MM-dd HH:mm:ss")));
	}

	@Test
	public void shouldReturnInvalidParameterExceptionWhenCalledWithNoValidDates() {
		when(priceRepositoryPort.findByBrandIdAndProductIdDateApplication(any(), any(), any()))
				.thenReturn(Optional.of(Collections.singletonList(price)));
		assertThrows(InvalidParameterException.class,
				() -> getPricesUseCase.getPricesInfo(brandId, productId,  DataConverter.getDate(applicationDateWrong, "yyyy-MM-dd HH:mm:ss")));
	}

	@Test
	public void shouldReturnInvalidParameterExceptionWhenCalledWithNoValidBrandId() {
		when(priceRepositoryPort.findByBrandIdAndProductIdDateApplication(any(), any(), any()))
				.thenReturn(Optional.of(Collections.singletonList(price)));
		assertThrows(InvalidParameterException.class,
				() -> getPricesUseCase.getPricesInfo(DataConverter.validateNumericParameters(brandIdWrong) , productId,
						DataConverter.getDate(applicationDate, "yyyy-MM-dd HH:mm:ss")));
	}

	@Test
	public void shouldReturnInvalidParameterExceptionWhenCalledWithNoValidProductId() {
		when(priceRepositoryPort.findByBrandIdAndProductIdDateApplication(any(), any(), any()))
				.thenReturn(Optional.of(Collections.singletonList(price)));
		assertThrows(InvalidParameterException.class,
				() -> getPricesUseCase.getPricesInfo(brandId,DataConverter.validateNumericParameters(productIdWrong),
						DataConverter.getDate(applicationDate, "yyyy-MM-dd HH:mm:ss")));
	}
}
