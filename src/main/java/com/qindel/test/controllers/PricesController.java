package com.qindel.test.controllers;


import com.qindel.test.domain.PriceDto;

import com.qindel.test.entities.Price;
import com.qindel.test.interfaces.PricesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
public class PricesController {

    @Autowired
    private PricesService pricesService;


    @GetMapping(path = "/prices")
    public ResponseEntity<List<PriceDto>> findPricesBy(
            @RequestParam(name="priceDate", required=false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime priceDate,
            @RequestParam(name="productId",required=false ) Long productId,
            @RequestParam(name="brandId",required=false ) Long brandId){

       List<PriceDto> prices = pricesService.findByFilters(priceDate, productId, brandId);

        return new ResponseEntity<>(prices, HttpStatus.OK);

    }


}
