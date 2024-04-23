package com.shaila.ejercicio.infraestructure.controllers;


import com.shaila.ejercicio.application.services.PriceService;
import com.shaila.ejercicio.infraestructure.dto.ResponsePriceDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador REST para la gestión de precios.
 */

@RestController
@RequestMapping("prices")
@Tag(name ="Precios resource")
@Slf4j
public class PriceController {

    private final PriceService priceService;

    /**
     * Constructor de la clase PriceController.
     *
     * @param priceService Servicio de precios para realizar operaciones.
     */
    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }
    /**
     * Consulta el precio final de un producto para una marca en una fecha específica.
     *
     * @param brandId         ID de la marca.
     * @param productId       ID del producto.
     * @param applicationDate Fecha de aplicación para la cual se busca el precio.
     * @return ResponseEntity con el DTO de respuesta que contiene la información del precio.
     */
    @Operation(summary="Consultar precio final de un producto para una cadena textil en una fecha específica")
    @GetMapping
    public ResponseEntity<ResponsePriceDto> getInfoPrices(
            @RequestParam Long brandId,
            @RequestParam Long productId,
            @RequestParam String applicationDate) {
        log.info("Consultando precio para brandId: {}, productId: {}, applicationDate: {}", brandId, productId, applicationDate);
        ResponsePriceDto response = priceService.getPricesInfo(brandId, productId, applicationDate);
        return ResponseEntity.ok(response);
    }

}
