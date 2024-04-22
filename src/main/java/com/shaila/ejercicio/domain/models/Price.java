package com.shaila.ejercicio.domain.models;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Price {

    Long brandId;
    LocalDateTime startDate;
    LocalDateTime endDate;
    int priceList;
    Long productId;
    int priority;
    Double price;
    String currency;
    

}
