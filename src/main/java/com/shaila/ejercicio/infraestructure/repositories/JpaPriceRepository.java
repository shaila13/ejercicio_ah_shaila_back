package com.shaila.ejercicio.infraestructure.repositories;

import com.shaila.ejercicio.infraestructure.entities.Prices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.Optional;
/**
 * JPA repository to access price data in the database.
 * Provides methods for performing customized queries on the Prices entity.
 */
@Repository
public interface JpaPriceRepository extends JpaRepository<Prices, Long> {

    /**
     * Custom query to retrieve a single price entry by brandId, productId, and application date,
     * ordered by descending priority.
     * @param brandId Brand ID.
     * @param productId Product ID.
     * @param applicationDate Application date for which the price is sought.
     * @return Optional containing the price entry matching the provided parameters.
     */
    @Query("SELECT p FROM Prices p WHERE p.brandId = :brandId AND p.productId = :productId AND :applicationDate between p.startDate and p.endDate ORDER BY p.priority DESC LIMIT 1")
    Optional<Prices> findByBrandIdAndProductIdAndApplicationDateOrderByPriorityDesc
            (@Param("brandId") Long brandId,@Param("productId") Long productId, @Param("applicationDate") LocalDateTime
                    applicationDate);
}
