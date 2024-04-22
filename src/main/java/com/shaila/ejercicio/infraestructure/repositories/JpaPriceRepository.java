package com.shaila.ejercicio.infraestructure.repositories;

import com.shaila.ejercicio.infraestructure.entities.Prices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface JpaPriceRepository extends JpaRepository<Prices, Long> {


    @Query("SELECT p FROM Prices p WHERE p.brandId = :brandId AND p.productId = :productId AND :applicationDate between p.startDate and p.endDate ORDER BY p.priority DESC")
    Optional< List<Prices>> findByBrandIdAndProductIdAndApplicationDateOrderByPriorityDesc
            (@Param("brandId") Long brandId,@Param("productId") Long productId, @Param("applicationDate") LocalDateTime
                    applicationDate);
}
