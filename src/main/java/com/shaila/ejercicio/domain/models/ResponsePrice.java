package com.shaila.ejercicio.domain.models;

import com.shaila.ejercicio.infraestructure.dto.PriceDto;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

/**
 * DTO (Data Transfer Object) class representing the price response.
 * Contains a {@link PriceDto} object representing the price.
 */
@AllArgsConstructor
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ResponsePrice implements Serializable {

    private static final long serialVersionUID = 1L;
    PriceDto price;

}
