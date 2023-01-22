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

    public Specification<Price> getPrices(LocalDateTime priceDate, Long productId, Long brand) {
        return (root, query, criteriaBuilder) -> {

            List<Predicate> predicates = new ArrayList<>();

            if(Objects.nonNull(productId)){
                predicates.add(criteriaBuilder.equal(root.get("productId"), productId));
            }

            if(Objects.nonNull(brand)){
                predicates.add(criteriaBuilder.equal(root.get("brandId"), brand));
            }

            if(Objects.nonNull(priceDate)){

               Subquery<Long> subQuery = query.subquery(Long.class);
               Root<Price> subRoot = subQuery.from(Price.class);

               Predicate endDatePredicateSub =  criteriaBuilder.greaterThan(subRoot.get("endDate"),priceDate);
               Predicate startDatePredicateSub =  criteriaBuilder.lessThan(subRoot.get("startDate"),priceDate);
               Predicate productPredicateSub =  criteriaBuilder.equal(subRoot.get("productId"), productId);
               Predicate brandPredicateSub =  criteriaBuilder.equal(subRoot.get("brandId"), brand);
               Expression<Long> maxPriority = criteriaBuilder.max(subRoot.get("priority"));

               subQuery.select(maxPriority).where(startDatePredicateSub, endDatePredicateSub, productPredicateSub, brandPredicateSub);

               predicates.add(criteriaBuilder.equal(root.get("priority"), subQuery));

               Predicate endDatePredicate =  criteriaBuilder.greaterThan(root.get("endDate"),priceDate);
               Predicate startDatePredicate =  criteriaBuilder.lessThan(root.get("startDate"),priceDate);

               predicates.add(endDatePredicate);
               predicates.add(startDatePredicate);

            }

            return  criteriaBuilder.and(predicates.toArray(new Predicate[0]));

        };
    }
}
