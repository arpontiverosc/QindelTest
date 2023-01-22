package com.qindel.test.domain;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class PriceDto {

    private Long productId;
    private Long brandId;
    private Long priceIdList;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String price;


}
