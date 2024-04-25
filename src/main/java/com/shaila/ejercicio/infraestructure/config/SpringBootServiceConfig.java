package com.shaila.ejercicio.infraestructure.config;

import com.shaila.ejercicio.application.usescases.GetPricesInfoUseCaseImpl;
import com.shaila.ejercicio.domain.ports.in.GetPricesInfoUseCase;
import com.shaila.ejercicio.domain.ports.out.PriceRepositoryPort;
import com.shaila.ejercicio.infraestructure.repositories.JpaPriceRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SpringBootServiceConfig {


  @Bean
  public GetPricesInfoUseCase priceService(PriceRepositoryPort priceRepositoryPort) {
    return  new GetPricesInfoUseCaseImpl(priceRepositoryPort);
  }

  @Bean
  public PriceRepositoryPort priceRepositoryPort(JpaPriceRepositoryAdapter jpaPriceRepositoryAdapter) {
    return jpaPriceRepositoryAdapter;
  }

}