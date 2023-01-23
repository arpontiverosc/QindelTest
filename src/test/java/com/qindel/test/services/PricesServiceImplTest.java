package com.qindel.test.services;

import com.qindel.test.domain.PriceDto;
import com.qindel.test.entities.Price;
import com.qindel.test.interfaces.PricesService;
import com.qindel.test.mappers.PricesMapper;
import com.qindel.test.mother.PricesMother;
import com.qindel.test.repositories.PriceRepository;
import com.qindel.test.specifications.PricesSpecification;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
public class PricesServiceImplTest {

    @InjectMocks
    private PricesServiceImpl pricesService;


    @Mock
    private PriceRepository priceRepository;

    @Mock
    private PricesSpecification priceSpecification;

    @Mock
    private PricesMapper pricesMapper;

    @Test
    public void findByFiltersTest(){

        LocalDateTime priceDate = LocalDateTime.now();
        Long productId = 1L;
        Long brandId = 1L;

        Mockito.when(priceRepository.findAll(ArgumentMatchers.any(Specification.class))).thenReturn(PricesMother.getPrices());


        Specification<Price>  specificationPrice = new Specification<Price>() {
            @Override
            public Predicate toPredicate(Root<Price> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return null;
            }
        };

        Mockito.when(priceSpecification.getPrices(ArgumentMatchers.any(LocalDateTime.class), ArgumentMatchers.anyLong(), ArgumentMatchers.anyLong()))
                .thenReturn(specificationPrice);

        Mockito.when(pricesMapper.converEntitytToDto(ArgumentMatchers.any())).thenReturn(PricesMother.getPricesDto());

        List<PriceDto>  priceDtos = pricesService.findByFilters(priceDate, productId, brandId);

        Assertions.assertNotNull(priceDtos.size());
        //...

    }
}
