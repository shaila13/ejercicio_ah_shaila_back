package com.shaila.ejercicio.infraestructure.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.time.LocalDateTime;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PriceDto implements Serializable {

    private static final long serialVersionUID = 1L;

    Long productId;
    Long brandId;
    int priceList;
    LocalDateTime startDate;
    LocalDateTime endDate;
    Double price;

}
