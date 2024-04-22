package com.shaila.ejercicio.infraestructure.controllers;


import com.shaila.ejercicio.application.services.PriceService;
import com.shaila.ejercicio.infraestructure.dto.ResponsePriceDto;
import com.shaila.ejercicio.infraestructure.exception.InvalidParameterException;
import com.shaila.ejercicio.infraestructure.exception.PriceNotFoundException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("prices")
@Tag(name ="Precios resource")
@Slf4j
public class PriceController {

    private final PriceService priceService;

    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }

    @Operation(summary="Consultar precio final de un producto para una cadena textil en una fecha específica")
    @GetMapping
    public ResponseEntity<ResponsePriceDto> getInfoPrices(
            @RequestParam Long brandId,
            @RequestParam Long productId,
            @RequestParam String starDate,
            @RequestParam String endDate) {

        ResponsePriceDto response = priceService.getPricesInfo(brandId, productId, starDate, endDate);
        return ResponseEntity.ok(response);
    }

}
