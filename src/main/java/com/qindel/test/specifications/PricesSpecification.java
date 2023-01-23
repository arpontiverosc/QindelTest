package com.qindel.test.specifications;

import com.qindel.test.entities.Price;
import jakarta.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class PricesSpecification {

    private static final String PRODUCT_ID = "productId";
    private static final String BRAND_ID = "brandId";
    private static final String END_DATE ="endDate";
    private static final String START_DATE = "startDate";
    private static final String PRIORITY = "priority";

    public Specification<Price> getPrices(LocalDateTime priceDate, Long productId, Long brand) {

        return (root, query, criteriaBuilder) -> {

            List<Predicate> predicates = new ArrayList<>();

            if(Objects.nonNull(productId)){
                predicates.add(criteriaBuilder.equal(root.get(PRODUCT_ID), productId));
            }

            if(Objects.nonNull(brand)){
                predicates.add(criteriaBuilder.equal(root.get(BRAND_ID), brand));
            }

            if(Objects.nonNull(priceDate)){

               Subquery<Long> subQueryMaxPriority = query.subquery(Long.class);
               Root<Price> subRoot = subQueryMaxPriority.from(Price.class);

               Predicate endDatePredicateSub =  criteriaBuilder.greaterThan(subRoot.get(END_DATE),priceDate);
               Predicate startDatePredicateSub =  criteriaBuilder.lessThan(subRoot.get(START_DATE),priceDate);
               Predicate productPredicateSub =  criteriaBuilder.equal(subRoot.get(PRODUCT_ID), productId);
               Predicate brandPredicateSub =  criteriaBuilder.equal(subRoot.get(BRAND_ID), brand);
               Expression<Long> maxPriority = criteriaBuilder.max(subRoot.get(PRIORITY));

               subQueryMaxPriority.select(maxPriority).where(startDatePredicateSub, endDatePredicateSub, productPredicateSub, brandPredicateSub);

               predicates.add(criteriaBuilder.equal(root.get(PRIORITY), subQueryMaxPriority));


               Predicate endDatePredicate =  criteriaBuilder.greaterThan(root.get(END_DATE),priceDate);
               Predicate startDatePredicate =  criteriaBuilder.lessThan(root.get(START_DATE),priceDate);

               predicates.add(endDatePredicate);
               predicates.add(startDatePredicate);

            }

            return  criteriaBuilder.and(predicates.toArray(new Predicate[0]));

        };
    }
}
