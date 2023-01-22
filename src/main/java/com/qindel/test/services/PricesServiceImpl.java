package com.qindel.test.services;

import com.qindel.test.domain.PriceDto;
import com.qindel.test.entities.Price;
import com.qindel.test.exceptions.PriceNotFoundException;
import com.qindel.test.interfaces.PricesService;
import com.qindel.test.mappers.PricesMapper;
import com.qindel.test.repositories.PriceRepository;
import com.qindel.test.specifications.PricesSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PricesServiceImpl implements PricesService {

    @Autowired
    private PriceRepository priceRepository;

    @Autowired
    private PricesSpecification priceSpecification;

    @Autowired
    private PricesMapper pricesMapper;

    @Override
    public List<PriceDto> findByFilters(LocalDateTime priceDate, Long productId, Long brand) {
        List<Price> prices = priceRepository.findAll(priceSpecification.getPrices(priceDate, productId, brand));
        if(prices.isEmpty()){
            throw new PriceNotFoundException("Prices no found.");
        }
        return pricesMapper.converEntitytToDto(prices);
    }
}
