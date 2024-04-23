package com.shaila.ejercicio.infraestructure.repositories;

import com.shaila.ejercicio.domain.models.Price;
import com.shaila.ejercicio.domain.ports.out.PriceRepositoryPort;
import com.shaila.ejercicio.infraestructure.entities.Prices;
import com.shaila.ejercicio.infraestructure.mappers.PriceDataAccessMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
/**
 * Adaptador de repositorio que implementa PriceRepositoryPort y utiliza JpaPriceRepository para interactuar con la base de datos.
 * Utiliza PriceDataAccessMapper para mapear entre los objetos del dominio y las entidades JPA.
 */
@Primary
@Component
@Slf4j
public class JpaPriceRepositoryAdapter implements PriceRepositoryPort {

    private final JpaPriceRepository jpaPriceRepository;

    private final PriceDataAccessMapper priceDataAccessMapper;
    /**
     * Constructor que recibe JpaPriceRepository y PriceDataAccessMapper.
     *
     * @param jpaPriceRepository  Repositorio JPA para acceder a los datos de precios.
     * @param priceDataAccessMapper Mapper para convertir entre objetos del dominio y entidades JPA.
     */
    public JpaPriceRepositoryAdapter(JpaPriceRepository jpaPriceRepository, PriceDataAccessMapper priceDataAccessMapper) {
        this.jpaPriceRepository = jpaPriceRepository;
        this.priceDataAccessMapper = priceDataAccessMapper;
    }

    @Override
    public List<Price> findByBrandIdAndProductIdDateApplication(Long brandId, Long productId, LocalDateTime applicationDate) {
        log.info("Consultando precios para brandId: {}, productId: {}, applicationDate: {}", brandId, productId, applicationDate);

        Optional<List<Prices>> optionalPricesList = jpaPriceRepository.
                findByBrandIdAndProductIdAndApplicationDateOrderByPriorityDesc(brandId,
                        productId, applicationDate);
        List<Prices> pricesList = optionalPricesList.orElse(Collections.emptyList());

        return pricesList.stream()
                .map(PriceDataAccessMapper::toDomainModel)
                .collect(Collectors.toList());
    }

}
