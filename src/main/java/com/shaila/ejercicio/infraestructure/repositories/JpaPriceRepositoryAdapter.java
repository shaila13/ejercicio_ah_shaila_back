package com.shaila.ejercicio.infraestructure.repositories;

import com.shaila.ejercicio.domain.models.Price;
import com.shaila.ejercicio.domain.ports.out.PriceRepositoryPort;
import com.shaila.ejercicio.infraestructure.mappers.PriceDataAccessMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;
/**
 * Repository adapter implementing PriceRepositoryPort and using JpaPriceRepository to interact with the database.
 * It uses PriceDataAccessMapper to map between domain objects and JPA entities.
 */
@Primary
@Component
@Slf4j
public class JpaPriceRepositoryAdapter implements PriceRepositoryPort {

    private final JpaPriceRepository jpaPriceRepository;

    private final PriceDataAccessMapper priceDataAccessMapper;
    /**
     * Constructor receiving JpaPriceRepository and PriceDataAccessMapper.
     *
     * @param jpaPriceRepository  JPA repository to access price data.
     * @param priceDataAccessMapper Mapper to convert between domain objects and JPA entities.
     */
    public JpaPriceRepositoryAdapter(JpaPriceRepository jpaPriceRepository, PriceDataAccessMapper priceDataAccessMapper) {
        this.jpaPriceRepository = jpaPriceRepository;
        this.priceDataAccessMapper = priceDataAccessMapper;
    }

    @Override
    public Optional<Price> findByBrandIdAndProductIdDateApplication(Long brandId, Long productId, LocalDateTime applicationDate) {
        log.info("Querying prices for brandId: {}, productId: {}, applicationDate: {}", brandId, productId, applicationDate);

        return jpaPriceRepository
                .findByBrandIdAndProductIdAndApplicationDateOrderByPriorityDesc(brandId, productId, applicationDate)
                .map(PriceDataAccessMapper::toDomainModel);
    }

}
