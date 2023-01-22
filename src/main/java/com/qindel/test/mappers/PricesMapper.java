package com.qindel.test.mappers;

import com.qindel.test.domain.PriceDto;
import com.qindel.test.entities.Price;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PricesMapper {


    public PriceDto convertToDto(Price price){
        PriceDto priceDto = new PriceDto();
        priceDto.setStartDate(price.getStartDate());
        priceDto.setEndDate(price.getEndDate());
        priceDto.setPrice(price.getPrice()+price.getCurr());
        priceDto.setPriceIdList(price.getPriceList());
        priceDto.setProductId(price.getProductId());
        priceDto.setBrandId(price.getBrandId());
        return priceDto;
    }


    public List<PriceDto> converEntitytToDto(List<Price> prices) {
        return prices.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
}
