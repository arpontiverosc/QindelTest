package com.qindel.test.mappers;

import com.qindel.test.domain.PriceDto;
import com.qindel.test.entities.Price;
import com.qindel.test.mother.PricesMother;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PricesMapperTest {

    @InjectMocks
    private PricesMapper pricesMapper;

    @Test
    public void convertEntityToDtoTest(){

        List<Price> prices = PricesMother.getPrices();

        List<PriceDto> priceDtos =  pricesMapper.converEntitytToDto(prices);

        Assertions.assertEquals(prices.size(), priceDtos.size());

    }

    @Test
    public void convertToDtoTest(){

        Price price = PricesMother.get();

        PriceDto priceDto = pricesMapper.convertToDto(price);


        Assertions.assertEquals(price.getPrice()+price.getCurr(), priceDto.getPrice());
        //...

    }

}
