package com.shaila.ejercicio.domain.ports.out;

import com.shaila.ejercicio.domain.models.Price;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
/**
 * Interfaz que define los métodos para acceder a los datos de precios en la capa de acceso a datos.
 * Implementaciones de esta interfaz proporcionan la lógica para recuperar precios de la fuente de datos subyacente.
 */
public interface PriceRepositoryPort {
   /**
    * Busca una lista de precios para una marca y producto específicos en una fecha de aplicación dada.
    *
    * @param brandId         El ID de la marca.
    * @param productId       El ID del producto.
    * @param applicationDate La fecha de aplicación para la cual se buscan los precios.
    * @return Un {@link Optional} que contiene una lista de {@link Price} si se encuentran precios para los
    *         parámetros proporcionados, o un {@link Optional} vacío si no se encontraron precios.
    */
   Optional<List<Price>> findByBrandIdAndProductIdDateApplication(Long brandId, Long productId, LocalDateTime applicationDate);

}
