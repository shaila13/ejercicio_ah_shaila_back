package com.shaila.ejercicio.infraestructure.mappers;

import com.shaila.ejercicio.domain.models.Price;
import com.shaila.ejercicio.domain.models.PriceDto;
import com.shaila.ejercicio.infraestructure.entities.Prices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Clase encargada de mapear entre los objetos del dominio y los objetos de acceso a datos (DTO y entidades).
 * Contiene métodos estáticos para convertir entre Price, PriceDto y Prices.
 */
@Component
@Slf4j
public class PriceDataAccessMapper {
    /**
     * Convierte un objeto Prices en un objeto Price del dominio.
     *
     * @param priceEntity Objeto Prices a convertir.
     * @return Objeto Price del dominio.
     */
    public static Price toDomainModel(Prices priceEntity){
        log.info("Mapeando Prices a Price: {}", priceEntity);
        return new Price( priceEntity.getBrandId(), priceEntity.getStartDate(), priceEntity.getEndDate(),
                priceEntity.getPriceList(),priceEntity.getProductId(), priceEntity.getPriority(),
                priceEntity.getPrice(), priceEntity.getCurr());
    }
    /**
     * Convierte un objeto Price del dominio en un objeto PriceDto.
     *
     * @param price Objeto Price del dominio a convertir.
     * @return Objeto PriceDto resultante.
     */
    public static PriceDto toPriceDto(Price price){
        log.info("Mapeando Price a PriceDto: {}", price);
        return new PriceDto(price.getProductId(),price.getBrandId(),price.getPriceList(), price.getStartDate(),
                price.getEndDate(), price.getPrice());
    }

}
