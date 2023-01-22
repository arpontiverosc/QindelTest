package com.qindel.test.repositories;

import com.qindel.test.entities.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long>, JpaSpecificationExecutor<Price> {

    //https://www.baeldung.com/rest-api-search-language-spring-data-specifications

    //https://www.youtube.com/watch?v=mr0ZB6QDz00


}
