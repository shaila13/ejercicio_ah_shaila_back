package com.shaila.ejercicio.infraestructure.controllers;


import com.shaila.ejercicio.application.services.PriceService;
import com.shaila.ejercicio.infraestructure.dto.ResponsePriceDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("app/prices")
@Tag(name ="Precios resource")
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

        return new ResponseEntity<>(priceService.getPricesInfo(brandId, productId, starDate, endDate), HttpStatus.OK);
    }

}
