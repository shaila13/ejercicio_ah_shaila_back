package com.shaila.ejercicio.domain.ports.out;

import com.shaila.ejercicio.domain.models.Price;


import java.time.LocalDateTime;
import java.util.List;

public interface PriceRepositoryPort {
   /**
    * Método para buscar precios por brandId, productId y fecha de aplicación.
    *
    * @param brandId         ID de la marca.
    * @param productId       ID del producto.
    * @param applicationDate Fecha de aplicación para la cual se buscan los precios.
    * @return Lista de precios que coinciden con los parámetros proporcionados.
    */
   List<Price>  findByBrandIdAndProductIdDateApplication(Long brandId, Long productId, LocalDateTime applicationDate);

}
