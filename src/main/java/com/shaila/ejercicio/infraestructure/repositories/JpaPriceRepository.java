package com.shaila.ejercicio.infraestructure.repositories;

import com.shaila.ejercicio.infraestructure.entities.Prices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.Optional;
/**
 * Repositorio JPA para acceder a los datos de precios en la base de datos.
 * Proporciona métodos para realizar consultas personalizadas sobre la entidad Prices.
 */
@Repository
public interface JpaPriceRepository extends JpaRepository<Prices, Long> {

    /**
     * Consulta personalizada para obtener una lista de precios por brandId, productId y fecha de aplicación.
     * La consulta busca precios que estén vigentes para la fecha de aplicación proporcionada.
     *
     * @param brandId        ID de la marca.
     * @param productId      ID del producto.
     * @param applicationDate Fecha de aplicación para la cual se buscan los precios.
     * @return Lista de precios que coinciden con los parámetros proporcionados, ordenados por prioridad descendente.
     */
    @Query("SELECT p FROM Prices p WHERE p.brandId = :brandId AND p.productId = :productId AND :applicationDate between p.startDate and p.endDate ORDER BY p.priority DESC LIMIT 1")
    Optional<Prices> findByBrandIdAndProductIdAndApplicationDateOrderByPriorityDesc
            (@Param("brandId") Long brandId,@Param("productId") Long productId, @Param("applicationDate") LocalDateTime
                    applicationDate);
}
