package com.qindel.test.interfaces;

import com.qindel.test.domain.PriceDto;

import java.time.LocalDateTime;
import java.util.List;

public interface PricesService {

    List<PriceDto> findByFilters(LocalDateTime priceDate, Long productId, Long brand);
}
