package com.shaila.ejercicio.infraestructure.repositories;

import com.shaila.ejercicio.domain.models.Price;
import com.shaila.ejercicio.domain.ports.out.PriceRepositoryPort;
import com.shaila.ejercicio.infraestructure.entities.Prices;
import com.shaila.ejercicio.infraestructure.mappers.PriceDataAccessMapper;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Primary
@Component
public class JpaPriceRepositoryAdapter implements PriceRepositoryPort {

    private final JpaPriceRepository jpaPriceRepository;

    private final PriceDataAccessMapper priceDataAccessMapper;

    public JpaPriceRepositoryAdapter(JpaPriceRepository jpaPriceRepository, PriceDataAccessMapper priceDataAccessMapper) {
        this.jpaPriceRepository = jpaPriceRepository;
        this.priceDataAccessMapper = priceDataAccessMapper;
    }

    @Override
    public List<Price> findByBrandIdAndProductIdDateApplication(Long brandId, Long productId, LocalDateTime applicationDate) {

        Optional<List<Prices>> optionalPricesList = jpaPriceRepository.
                findByBrandIdAndProductIdAndApplicationDateOrderByPriorityDesc(brandId,
                        productId, applicationDate);
        List<Prices> pricesList = optionalPricesList.orElse(Collections.emptyList());

        return pricesList.stream()
                .map(PriceDataAccessMapper::toDomainModel)
                .collect(Collectors.toList());
    }

}
