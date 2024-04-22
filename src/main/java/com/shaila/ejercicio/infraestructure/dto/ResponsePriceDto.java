package com.shaila.ejercicio.infraestructure.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ResponsePriceDto {

    List<PriceDto> prices;

    public ResponsePriceDto(List<PriceDto> prices) {
        this.prices =  prices;
    }
}
