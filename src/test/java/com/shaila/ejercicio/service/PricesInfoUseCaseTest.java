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
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class PricesInfoUseCaseTest {

	private static final Long BRAND_ID = 1L;
	private static final Long PRODUCT_ID = 35455L;
	private static final String BRAND_ID_WRONG = null;
	private static final String PRODUCT_ID_WRONG = null;

	private static final String APPLICATION_DATE = "2020-06-14 00:00:00";
	private static final String APPLICATION_DATE_WRONG = "2020-06-14-00:00:00";
	private static final double PRICE = 35.50;
	private static final double PRICE_1 = 25.45;

	private Price price;
	private Price price2;
	private PriceDto priceDto;
	private List<Price> priceList;
	private ResponsePrice responsePriceDto;
	@MockBean(name = "priceRepositoryPort")
	private PriceRepositoryPort priceRepositoryPort;

	@MockBean(name = "jpaPriceRepositoryAdapter")
	private JpaPriceRepositoryAdapter jpaPriceRepositoryAdapter;

	@InjectMocks
	private GetPricesInfoUseCaseImpl getPricesUseCase;


	@BeforeEach
	void setUp() {
		price = new Price(PRODUCT_ID, BRAND_ID,1, LocalDateTime.now(), LocalDateTime.now().plusHours(1),
				PRICE, 1, "EUR");
		price2 = new Price(PRODUCT_ID, BRAND_ID, 2, LocalDateTime.now(), LocalDateTime.now().plusHours(1),
				PRICE_1,0,  "EUR");
		priceDto = new PriceDto(PRODUCT_ID,BRAND_ID,1,  LocalDateTime.now(), LocalDateTime.now().plusHours(1),
				PRICE);

		priceList = Arrays.asList(price,price2);
		responsePriceDto = new ResponsePrice(priceDto);
		priceRepositoryPort = mock(PriceRepositoryPort.class);
		jpaPriceRepositoryAdapter = mock(JpaPriceRepositoryAdapter.class);
		getPricesUseCase = new GetPricesInfoUseCaseImpl(priceRepositoryPort);

	}

	@Test
	public void shouldReturnPricesWhenCalledWithValidParameters(){
		when(priceRepositoryPort.findByBrandIdAndProductIdDateApplication(any(), any(), any()))
				.thenReturn(Optional.ofNullable(price));
		ResponsePrice result = getPricesUseCase.getPricesInfo(BRAND_ID, PRODUCT_ID, DataConverter.getDate(APPLICATION_DATE,
				"yyyy-MM-dd HH:mm:ss") );
		assertNotNull(result);
		assertNotNull(result.getPrice());
		assertEquals(35.50, result.getPrice().getPrice());
		verify(priceRepositoryPort, times(1))
				.findByBrandIdAndProductIdDateApplication(BRAND_ID, PRODUCT_ID, LocalDateTime.parse(APPLICATION_DATE,
						DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

	}

	@Test
	public void shouldReturnPriceNotFoundExceptionWhenDoNotFindAnyPrices() {
		when(priceRepositoryPort.findByBrandIdAndProductIdDateApplication(anyLong(), anyLong(), any()))
				.thenReturn(Optional.empty());
		assertThrows(PriceNotFoundException.class,
				() -> getPricesUseCase.getPricesInfo(BRAND_ID, PRODUCT_ID, DataConverter.getDate(APPLICATION_DATE,
						"yyyy-MM-dd HH:mm:ss")));
	}

	@Test
	public void shouldReturnInvalidParameterExceptionWhenCalledWithNoValidDates() {
		when(priceRepositoryPort.findByBrandIdAndProductIdDateApplication(any(), any(), any()))
				.thenReturn(Optional.ofNullable(price));
		assertThrows(InvalidParameterException.class,
				() -> getPricesUseCase.getPricesInfo(BRAND_ID, PRODUCT_ID,  DataConverter.getDate(APPLICATION_DATE_WRONG,
						"yyyy-MM-dd HH:mm:ss")));
	}

	@Test
	public void shouldReturnInvalidParameterExceptionWhenCalledWithNoValidBrandId() {
		when(priceRepositoryPort.findByBrandIdAndProductIdDateApplication(any(), any(), any()))
				.thenReturn(Optional.ofNullable(price));
		assertThrows(InvalidParameterException.class,
				() -> getPricesUseCase.getPricesInfo(DataConverter.validateNumericParameters(BRAND_ID_WRONG) , PRODUCT_ID,
						DataConverter.getDate(APPLICATION_DATE, "yyyy-MM-dd HH:mm:ss")));
	}

	@Test
	public void shouldReturnInvalidParameterExceptionWhenCalledWithNoValidProductId() {
		when(priceRepositoryPort.findByBrandIdAndProductIdDateApplication(any(), any(), any()))
				.thenReturn(Optional.ofNullable(price));
		assertThrows(InvalidParameterException.class,
				() -> getPricesUseCase.getPricesInfo(BRAND_ID,DataConverter.validateNumericParameters(PRODUCT_ID_WRONG),
						DataConverter.getDate(APPLICATION_DATE, "yyyy-MM-dd HH:mm:ss")));

	}

}
