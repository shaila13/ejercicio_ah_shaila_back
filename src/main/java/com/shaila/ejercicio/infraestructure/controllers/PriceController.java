package com.shaila.ejercicio.infraestructure.controllers;


import com.shaila.ejercicio.application.services.PriceService;
import com.shaila.ejercicio.infraestructure.dto.ResponsePriceDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/prices")
public class PriceController {

    private final PriceService priceService;

    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }

    @GetMapping
    public ResponseEntity<ResponsePriceDto> getInfoPrices(
            @RequestParam Long brandId,
            @RequestParam Long productId,
            @RequestParam String starDate,
            @RequestParam String endDate) {

        return new ResponseEntity<>(priceService.getPricesInfo(brandId, productId, starDate, endDate), HttpStatus.OK);
    }

}
