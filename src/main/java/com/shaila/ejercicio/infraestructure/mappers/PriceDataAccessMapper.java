package com.shaila.ejercicio.infraestructure.mappers;

import com.shaila.ejercicio.domain.models.Price;
import com.shaila.ejercicio.infraestructure.dto.PriceDto;
import com.shaila.ejercicio.infraestructure.entities.Prices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Class responsible for mapping between domain objects and data access objects (DTOs and entities).
 * Contains static methods to convert between Price, PriceDto, and Prices.
 */
@Component
@Slf4j
public class PriceDataAccessMapper {
    /**
     * Converts a Prices object to a domain model Price.
     *
     * @param priceEntity Prices object to convert.
     * @return Domain model Price object.
     */
    public static Price toDomainModel(Prices priceEntity){
        log.info("Mapping Prices to Price: {}", priceEntity);
        return new Price(priceEntity.getBrandId(), priceEntity.getStartDate(), priceEntity.getEndDate(),
                priceEntity.getPriceList(), priceEntity.getProductId(), priceEntity.getPriority(),
                priceEntity.getPrice(), priceEntity.getCurr());
    }
    /**
     * Converts a domain model Price object to a PriceDto object.
     *
     * @param price Domain model Price object to convert.
     * @return Resulting PriceDto object.
     */
    public static PriceDto toPriceDto(Price price){
        log.info("Mapping Price to PriceDto: {}", price);
        return new PriceDto(price.getProductId(), price.getBrandId(), price.getPriceList(), price.getStartDate(),
                price.getEndDate(), price.getPrice());
    }

}
