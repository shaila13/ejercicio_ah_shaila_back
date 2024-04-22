package com.shaila.ejercicio.infraestructure.mappers;

import com.shaila.ejercicio.domain.models.Price;
import com.shaila.ejercicio.infraestructure.dto.PriceDto;
import com.shaila.ejercicio.infraestructure.entities.Prices;
import org.springframework.stereotype.Component;


@Component
public class PriceDataAccessMapper {

    public static Price toDomainModel(Prices priceEntity){
        return new Price( priceEntity.getBrandId(), priceEntity.getStartDate(), priceEntity.getEndDate(),
                priceEntity.getPriceList(),priceEntity.getProductId(), priceEntity.getPriority(),
                priceEntity.getPrice(), priceEntity.getCurr());
    }

    public static PriceDto toPriceDto(Price price){
        return new PriceDto(price.getProductId(),price.getBrandId(),price.getPriceList(), price.getStartDate(),
                price.getEndDate(), price.getPrice());
    }

}
