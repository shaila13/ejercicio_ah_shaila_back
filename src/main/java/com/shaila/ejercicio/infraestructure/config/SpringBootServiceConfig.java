package com.shaila.ejercicio.infraestructure.config;


import com.shaila.ejercicio.application.services.PriceService;
import com.shaila.ejercicio.application.usescases.GetPricesUseCaseImpl;
import com.shaila.ejercicio.domain.ports.out.PriceRepositoryPort;
import com.shaila.ejercicio.infraestructure.repositories.JpaPriceRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SpringBootServiceConfig {

  @Bean
  public PriceService priceService(PriceRepositoryPort priceRepositoryPort) {
    return new PriceService( new GetPricesUseCaseImpl(priceRepositoryPort));
  }


  @Bean
  public PriceRepositoryPort priceRepositoryPort(JpaPriceRepositoryAdapter jpaPriceRepositoryAdapter) {
    return jpaPriceRepositoryAdapter;
  }

}