package com.shaila.ejercicio.infraestructure.controllers;


import com.shaila.ejercicio.domain.models.ResponsePrice;
import com.shaila.ejercicio.domain.ports.in.GetPricesInfoUseCase;
import com.shaila.ejercicio.infraestructure.utils.DataConverter;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * REST controller for price management.
 */

@RestController
@RequestMapping("prices")
@Tag(name ="Precios resource")
@Slf4j
public class PriceController {

    private final GetPricesInfoUseCase getPricesInfoUseCase;

    /**
     * Constructor of the PriceController class.
     *
     * @param getPricesInfoUseCase Price service for performing operations.
     */
    public PriceController(GetPricesInfoUseCase getPricesInfoUseCase) {
        this.getPricesInfoUseCase = getPricesInfoUseCase;
    }
    /**
     * Queries the final price of a product for a brand on a specific date.
     *
     * @param brandId         Brand ID.
     * @param productId       Product ID.
     * @param applicationDate Date of application for which the price is sought.
     * @return ResponseEntity with the response DTO containing price information.
     */
    @Operation(summary="Query final price of a product for a textile chain on a specific date")
    @GetMapping
    public ResponseEntity<ResponsePrice> getInfoPrices(
            @RequestParam String brandId,
            @RequestParam String productId,
            @RequestParam String applicationDate) {
        log.info("Querying price for brandId: {}, productId: {}, applicationDate: {}", brandId, productId,
                applicationDate);

        ResponsePrice response = getPricesInfoUseCase.getPricesInfo(
                DataConverter.validateNumericParameters(brandId),
                DataConverter.validateNumericParameters(productId),
                DataConverter.getDate(applicationDate, "yyyy-MM-dd HH:mm:ss"));
        return ResponseEntity.ok(response);
    }


}
