package com.shaila.ejercicio.infraestructure.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;


@Entity
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "PRICES")
public class Prices  implements Serializable {

    static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long pricesId;

    @NotNull
    Long productId;
    @NotNull
    Long brandId;
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    LocalDateTime startDate;
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    LocalDateTime endDate;
    double price;
    int priceList;
    int priority;
    String curr;

    public Prices() {
    }

    public Prices(Long productId, Long brandId, LocalDateTime startDate, LocalDateTime endDate, double price,
                  int priceList, int priority, String curr) {
        this.productId = productId;
        this.brandId = brandId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;
        this.priceList = priceList;
        this.priority = priority;
        this.curr = curr;
    }


}
