package com.shaila.ejercicio.domain.models;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Getter
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

    public Price() {
    }
    public Price(Long brandId, LocalDateTime startDate, LocalDateTime endDate, int priceList, Long productId, int priority, Double price, String currency) {
        this.brandId = brandId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.priceList = priceList;
        this.productId = productId;
        this.priority = priority;
        this.price = price;
        this.currency = currency;
    }

}
