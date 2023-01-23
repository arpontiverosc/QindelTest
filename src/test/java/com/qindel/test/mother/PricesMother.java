package com.qindel.test.mother;

import com.qindel.test.domain.PriceDto;
import com.qindel.test.entities.Price;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PricesMother {


    public static Price get(){
        Price price = new Price();
        price.setPrice(BigDecimal.TEN);
        price.setCurr("EUR");
        //..
        return price;
    }

    public static List<Price> getPrices() {
        List<Price> prices = new ArrayList<>();
        prices.add(get());
        return prices;
    }

    public static PriceDto getDto(){
        PriceDto priceDto = new PriceDto();
        priceDto.setPrice("35.50EUR");
        //..
        return priceDto;
    }


    public static  List<PriceDto> getPricesDto(){
        List<PriceDto> pricesDtos = new ArrayList<>();
        pricesDtos.add(getDto());
        return pricesDtos;
    }
}
