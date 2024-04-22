package com.shaila.ejercicio.infraestructure.dto;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;


@Setter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PriceDto {

    Long productId;
    Long brandId;
    int priceList;
    LocalDateTime startDate;
    LocalDateTime endDate;
    Double price;

    public PriceDto(Long productId, Long brandId, int priceList, LocalDateTime startDate, LocalDateTime endDate,
                    Double price) {
        this.productId = productId;
        this.brandId = brandId;
        this.priceList = priceList;
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;
    }

}
