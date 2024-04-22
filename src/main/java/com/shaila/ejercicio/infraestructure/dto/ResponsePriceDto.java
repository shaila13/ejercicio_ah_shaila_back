package com.shaila.ejercicio.infraestructure.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ResponsePriceDto implements Serializable {

    private static final long serialVersionUID = 1L;

    List<PriceDto> prices;

}
