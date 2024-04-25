package com.shaila.ejercicio.infraestructure.controllers;


import com.shaila.ejercicio.domain.models.ResponsePriceDto;
import com.shaila.ejercicio.domain.ports.in.GetPricesInfoUseCase;
import com.shaila.ejercicio.infraestructure.utils.DataConverter;
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

    private final GetPricesInfoUseCase getPricesInfoUseCase;

    /**
     * Constructor de la clase PriceController.
     *
     * @param getPricesInfoUseCase Servicio de precios para realizar operaciones.
     */
    public PriceController(GetPricesInfoUseCase getPricesInfoUseCase) {
        this.getPricesInfoUseCase = getPricesInfoUseCase;
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
            @RequestParam String brandId,
            @RequestParam String productId,
            @RequestParam String applicationDate) {
        log.info("Consultando precio para brandId: {}, productId: {}, applicationDate: {}", brandId, productId, applicationDate);

        ResponsePriceDto response = getPricesInfoUseCase.getPricesInfo(
                DataConverter.validateNumericParameters(brandId),
                DataConverter.validateNumericParameters(productId),
                DataConverter.getDate(applicationDate, "yyyy-MM-dd HH:mm:ss"));
        return ResponseEntity.ok(response);
    }


}
