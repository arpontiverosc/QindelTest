package com.qindel.test.controllers;


import com.qindel.test.domain.PriceDto;
import com.qindel.test.interfaces.PricesService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class PricesControllerTest {


    @InjectMocks
    private PricesController pricesController;

    @Mock
    private PricesService pricesService;

    @Test
    public void findPricesByFoundPriceTest(){

        LocalDateTime priceDate = LocalDateTime.now();
        Long productId = 1L;
        Long brandId = 1L;

        List<PriceDto>  pricesDto = new ArrayList<>();

        Mockito.when(pricesService.findByFilters(ArgumentMatchers.any(), ArgumentMatchers.anyLong(), ArgumentMatchers.anyLong())).thenReturn(pricesDto);

        ResponseEntity<List<PriceDto>> pricesResponse = pricesController.findPricesBy(priceDate, productId, brandId);

        Assertions.assertEquals(HttpStatus.OK, pricesResponse.getStatusCode());

    }
}
