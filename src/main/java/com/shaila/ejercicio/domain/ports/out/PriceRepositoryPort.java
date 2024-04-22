package com.shaila.ejercicio.domain.ports.out;

import com.shaila.ejercicio.domain.models.Price;


import java.time.LocalDateTime;
import java.util.List;

public interface PriceRepositoryPort {

   List<Price>  findByBrandIdAndProductIdDateApplication(Long brandId, Long productId, LocalDateTime starDate,
                                                         LocalDateTime endDate);

}
