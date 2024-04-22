package com.shaila.ejercicio.infraestructure.repositories;

import com.shaila.ejercicio.infraestructure.entities.Prices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface JpaPriceRepository extends JpaRepository<Prices, Long> {

    List<Prices> findByBrandIdAndProductIdAndStartDateGreaterThanEqualAndEndDateLessThanEqualOrderByPriorityDesc
            (@Param("brandId") Long brandId,@Param("productId") Long productId, @Param("starDate") LocalDateTime
                    starDate , @Param("endDate") LocalDateTime endDate);
}
